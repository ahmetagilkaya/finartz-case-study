package tr.com.finartz.casestudy.model.dto.airline;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineCreateDTO {

    @NotBlank(message = "airlineName field cannot be null or empty.")
    @Size(max = 255, message = "airlineName must be max 255 characters.")
    @ApiModelProperty(name = "airportCountry", example = "Türk Hava Yolları")
    private String airlineName;

    @NotBlank(message = "phoneNumber field cannot be null or empty.")
    @Size(min = 11, max = 11, message = "phoneNumber must be 11 characters.")
    @Pattern(regexp="(^$|[0-9]{11})", message = "phoneNumber must be numbers only.")
    @ApiModelProperty(name = "airportCountry", example = "05061435087")
    private String phoneNumber;

    @NotBlank(message = "email field cannot be null or empty.")
    @ApiModelProperty(name = "airportCountry", example = "thy@thy.com")
    @Email(message = "E-mail is not valid.")
    private String email;

}
