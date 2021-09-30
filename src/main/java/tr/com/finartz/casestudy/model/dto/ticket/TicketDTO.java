package tr.com.finartz.casestudy.model.dto.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.finartz.casestudy.model.dto.flight.FlightDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private Long id;
    private String ticketNumber;
    private Double ticketPrice;
    private FlightDTO flight;
    private String purchasedCreditCardNumber;
    private Boolean isCancelled;

}
