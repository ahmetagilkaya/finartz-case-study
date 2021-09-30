package tr.com.finartz.casestudy.model.dto.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class RouteEditDTO extends RouteCreateDTO {

    @NotNull(message = "id field cannot be null")
    private Long id;

}
