package tr.com.finartz.casestudy.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.finartz.casestudy.model.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "AIRPORTS")
@SequenceGenerator(sequenceName = "airports_seq", allocationSize = 1, name = "my_seq_gen")
public class Airport extends BaseEntity {

    @NotBlank(message = "airportName field cannot be null or empty.")
    @Column(name = "AIRPORT_NAME", nullable = false)
    private String airportName;

    @NotBlank(message = "airportCode field cannot be null or empty.")
    @Column(name = "AIRPORT_CODE", unique = true, nullable = false)
    private String airportCode;

    @NotBlank(message = "airportCountry field cannot be null or empty.")
    @Column(name = "AIRPORT_COUNTRY", nullable = false)
    private String airportCountry;

    @NotBlank(message = "airportCity field cannot be null or empty.")
    @Column(name = "AIRPORT_CITY", nullable = false)
    private String airportCity;

}
