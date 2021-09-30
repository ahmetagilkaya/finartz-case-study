package tr.com.finartz.casestudy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.finartz.casestudy.core.helper.DTOtoEntityHelper;
import tr.com.finartz.casestudy.core.mapper.DTOMapper;
import tr.com.finartz.casestudy.model.dto.ticket.TicketCreateDTO;
import tr.com.finartz.casestudy.model.dto.ticket.TicketDTO;
import tr.com.finartz.casestudy.service.TicketService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final DTOtoEntityHelper dtOtoEntityHelper;
    private final DTOMapper dtoMapper;


    @PostMapping(value = "/buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> buyTicket(@Valid @RequestBody TicketCreateDTO ticketCreateDTO)  {
        return new ResponseEntity<>(dtoMapper.mapModel(ticketService.buyTicket(dtOtoEntityHelper.convertTicketCreateDTOtoTicket(ticketCreateDTO)), TicketDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/cancel-ticket-by-ticket-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> cancelTicketByTicketId(@RequestParam(name = "ticketId") Long ticketId) {
        return new ResponseEntity<>(dtoMapper.mapModel(ticketService.cancelTicketByTicketId(ticketId), TicketDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/cancel-ticket-by-ticket-number", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> cancelTicketByTicketNumber(@RequestParam(name = "ticketNumber") String ticketNumber) {
        return new ResponseEntity<>(dtoMapper.mapModel(ticketService.cancelTicketByTicketNumber(ticketNumber), TicketDTO.class), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteTicketById(@RequestParam(name = "id") Long id)  {
        ticketService.deleteTicketById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> findTicketById(@RequestParam(name = "id") Long id) {
        return new ResponseEntity<>(dtoMapper.mapModel(ticketService.findTicketById(id), TicketDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-ticket-number", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> findTicketByTicketNumber(@RequestParam(name = "ticketNumber") String ticketNumber) {
        return new ResponseEntity<>(dtoMapper.mapModel(ticketService.findByTicketNumber(ticketNumber), TicketDTO.class), HttpStatus.OK);
    }

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TicketDTO>> findAllTickets() {
        return new ResponseEntity<>(dtoMapper.mapListModel(ticketService.findAllTickets(), TicketDTO.class), HttpStatus.OK);
    }

}
