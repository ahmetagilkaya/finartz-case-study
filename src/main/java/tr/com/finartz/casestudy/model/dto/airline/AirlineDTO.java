package tr.com.finartz.casestudy.model.dto.airline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDTO {

    private Long id;
    private String airlineName;
    private String phoneNumber;
    private String email;

}
