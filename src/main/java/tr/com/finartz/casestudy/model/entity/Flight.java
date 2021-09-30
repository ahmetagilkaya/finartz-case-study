package tr.com.finartz.casestudy.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import tr.com.finartz.casestudy.model.entity.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "FLIGHTS")
@SequenceGenerator(sequenceName = "flights_seq", allocationSize = 1, name = "my_seq_gen")
public class Flight extends BaseEntity {

    @NotBlank(message = "flightName field cannot be null or empty.")
    @Column(name = "FLIGHT_NAME", unique = true, nullable = false)
    private String flightName;

    @NotNull(message = "flightDate field cannot be null.")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FLIGHT_DATE")
    private Date flightDate;

    @NotNull(message = "flightTimeMinutes field cannot be null.")
    @Column(name = "FLIGHT_TIME_MINUTES")
    private Integer flightTimeMinutes;

    @NotNull(message = "quota field cannot be null.")
    @Column(name = "QUOTA")
    private Integer quota;

    @NotNull(message = "price field cannot be null.")
    @Column(name = "PRICE")
    private Double price;

    @NotNull(message = "airline field cannot be null.")
    @ManyToOne(optional = false, fetch = FetchType.LAZY , cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "AIRLINE_ID")
    private Airline airline;

    @NotNull(message = "route field cannot be null.")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ROUTE_ID")
    private Route route;

    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    public Flight() {
        tickets = new ArrayList<>();
    }

}
