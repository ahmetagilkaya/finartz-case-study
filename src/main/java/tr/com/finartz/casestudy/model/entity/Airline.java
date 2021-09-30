package tr.com.finartz.casestudy.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import tr.com.finartz.casestudy.model.entity.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "AIRLINES")
@SequenceGenerator(sequenceName = "airlines_seq", allocationSize = 1, name = "my_seq_gen")
public class Airline extends BaseEntity {

    @NotBlank(message = "airlineName field cannot be null or empty.")
    @Column(name = "AIRLINE_NAME", unique = true, nullable = false)
    private String airlineName;

    @NotBlank(message = "phoneNumber field cannot be null or empty.")
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "email field cannot be null or empty.")
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @OneToMany(mappedBy = "airline", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flight> flights;

    public Airline() {
        flights = new ArrayList<>();
    }

}
