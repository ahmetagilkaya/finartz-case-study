package tr.com.finartz.casestudy.model.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tr.com.finartz.casestudy.model.dto.airport.AirportDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDTO {

    private Long id;
    private String routeName;
    private AirportDTO from;
    private AirportDTO to;

}
