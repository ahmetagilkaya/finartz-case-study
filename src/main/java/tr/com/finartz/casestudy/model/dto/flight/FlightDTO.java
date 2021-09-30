package tr.com.finartz.casestudy.model.dto.flight;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.finartz.casestudy.model.dto.airline.AirlineDTO;
import tr.com.finartz.casestudy.model.dto.route.RouteDTO;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {

    private Long id;
    private String flightName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private Date flightDate;
    private Integer flightTimeMinutes;
    private Integer price;
    private Integer quota;
    private AirlineDTO airline;
    private RouteDTO route;

}
