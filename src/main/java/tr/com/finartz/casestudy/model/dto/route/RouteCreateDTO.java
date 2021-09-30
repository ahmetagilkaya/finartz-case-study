package tr.com.finartz.casestudy.model.dto.route;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteCreateDTO {

    @NotBlank(message = "routeName field cannot be null or empty.")
    @ApiModelProperty(name = "routeName", example = "Ankara-İstanbul")
    private String routeName;

    @NotNull(message = "fromAirportId field cannot be null or empty.")
    @ApiModelProperty(name = "fromAirportId", example = "1")
    private Long fromAirportId;

    @NotNull(message = "toAirportId field cannot be null or empty.")
    @ApiModelProperty(name = "toAirportId", example = "2")
    private Long toAirportId;

}
