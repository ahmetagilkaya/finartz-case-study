package tr.com.finartz.casestudy.model.dto.airport;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportCreateDTO {

    @NotBlank(message = "airportName field cannot be null or empty.")
    @Size(max = 255, message = "airportName must be max 255 characters.")
    @ApiModelProperty(name = "airportName", example = "Sabiha Gökçen Havaalanı")
    private String airportName;

    @NotBlank(message = "airportCode field cannot be null or empty.")
    @Size(max = 255, message = "airportCode must be max 255 characters.")
    @ApiModelProperty(name = "airportCode", example = "TR-34-01")
    private String airportCode;

    @NotBlank(message = "airportCountry field cannot be null or empty.")
    @Size(max = 255, message = "airportCountry must be max 255 characters.")
    @ApiModelProperty(name = "airportCountry", example = "Türkiye")
    private String airportCountry;

    @NotBlank(message = "airportCity field cannot be null or empty.")
    @Size(max = 255, message = "airportCity must be max 255 characters.")
    @ApiModelProperty(name = "airportCity", example = "İstanbul")
    private String airportCity;

}
