package tr.com.finartz.casestudy.model.dto.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO {

    private Long id;
    private String airportName;
    private String airportCode;
    private String airportCountry;
    private String airportCity;

}
