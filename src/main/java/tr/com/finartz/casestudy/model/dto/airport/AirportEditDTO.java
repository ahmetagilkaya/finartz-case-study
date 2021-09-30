package tr.com.finartz.casestudy.model.dto.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class AirportEditDTO extends AirportCreateDTO {

    @NotNull(message = "id field cannot be null")
    private Long id;

}
