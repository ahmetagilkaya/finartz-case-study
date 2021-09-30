package tr.com.finartz.casestudy.model.dto.ticket;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.finartz.casestudy.core.validation.CreditCard;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCreateDTO {

    @NotNull(message = "flightId field cannot be null or empty.")
    @ApiModelProperty(name = "flightId", example = "1")
    private Long flightId;

    @NotBlank(message = "purchasedCreditCardNumber field cannot be null or empty.")
    @CreditCard(message = "purchasedCreditCardNumber field is not valid.")
    @ApiModelProperty(name = "purchasedCreditCardNumber", example = "4221 1611 2233 0005")
    private String purchasedCreditCardNumber;

}
