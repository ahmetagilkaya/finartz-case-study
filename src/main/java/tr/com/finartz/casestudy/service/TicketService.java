package tr.com.finartz.casestudy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import tr.com.finartz.casestudy.core.helper.PriceCalculateHelper;
import tr.com.finartz.casestudy.core.util.CreditCardUtil;
import tr.com.finartz.casestudy.model.entity.Ticket;
import tr.com.finartz.casestudy.repository.TicketRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final PriceCalculateHelper priceCalculateHelper;

    @Transactional(readOnly = true)
    public Ticket findTicketById(Long id){
        return ticketRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No ticket record for this id = %d could be found.", id)));
    }

    @Transactional(readOnly = true)
    public Ticket findByTicketNumber(String ticketNumber){
        return ticketRepository
                .findByTicketNumber(ticketNumber)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No ticket record for this ticketNumber = %s could be found.", ticketNumber)));
    }

    @Transactional(readOnly = true)
    public List<Ticket> findAllTickets() {
        return ticketRepository.findAll();
    }

    @Transactional
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Transactional
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }

    @Transactional
    public Ticket buyTicket(Ticket ticket){
        Integer totalTicketCountOfFlight = ticket.getFlight().getTickets().stream().filter(currentTicker -> currentTicker.getIsCancelled().equals(false)).collect(Collectors.toList()).size();

        if(totalTicketCountOfFlight >= ticket.getFlight().getQuota()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("There are no vacancies left on %s flight.", ticket.getFlight().getFlightName()));
        }

        ticket.setPurchasedCreditCardNumber(CreditCardUtil.hideCreditCard(CreditCardUtil.getValidCreditCardString(ticket.getPurchasedCreditCardNumber())));
        ticket.setTicketPrice(priceCalculateHelper.calculateTicketPrice(ticket.getFlight().getQuota(), totalTicketCountOfFlight, ticket.getFlight().getPrice()));
        return saveTicket(ticket);
    }

    @Transactional
    public Ticket cancelTicketByTicketId(Long ticketId) {
        Ticket ticket = findTicketById(ticketId);
        ticket.setIsCancelled(true);
        return saveTicket(ticket);
    }

    @Transactional
    public Ticket cancelTicketByTicketNumber(String ticketNumber) {
        Ticket ticket = findByTicketNumber(ticketNumber);
        ticket.setIsCancelled(true);
        return saveTicket(ticket);
    }

}
