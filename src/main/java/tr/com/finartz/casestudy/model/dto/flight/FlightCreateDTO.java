package tr.com.finartz.casestudy.model.dto.flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightCreateDTO {

    @NotBlank(message = "flightName field cannot be null or empty.")
    @ApiModelProperty(name = "flightName", example = "THY ANK-IST")
    private String flightName;

    @NotNull(message = "flightDate field cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    @ApiModelProperty(name = "flightDate", example = "2021-09-30 20:18")
    private Date flightDate;

    @NotNull(message = "flightTimeMinutes field cannot be null.")
    @ApiModelProperty(name = "flightTimeMinutes", example = "50")
    private Integer flightTimeMinutes;

    @NotNull(message = "quota field cannot be null.")
    @ApiModelProperty(name = "quota", example = "100")
    private Integer quota;

    @NotNull(message = "price field cannot be null.")
    @ApiModelProperty(name = "price", example = "65.0")
    private Double price;

    @NotNull(message = "airlineId field cannot be null.")
    @ApiModelProperty(name = "airlineId", example = "1")
    private Long airlineId;

    @NotNull(message = "routeId field cannot be null.")
    @ApiModelProperty(name = "routeId", example = "1")
    private Long routeId;

}
