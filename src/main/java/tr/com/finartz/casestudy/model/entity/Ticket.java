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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "TICKETS")
@SequenceGenerator(sequenceName = "tickets_seq", allocationSize = 1, name = "my_seq_gen")
public class Ticket extends BaseEntity {

    @NotBlank(message = "ticketNumber field cannot be null or empty.")
    @Column(name = "TICKET_NUMBER", unique = true, nullable = false)
    private String ticketNumber;

    @NotNull(message = "ticketPrice field cannot be null.")
    @Column(name = "TICKET_PRICE")
    private Double ticketPrice;

    @NotNull(message = "flight field cannot be null or empty.")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    @NotBlank(message = "purchasedCreditCardNumber field cannot be null or empty.")
    @Column(name = "PURCHASED_CREDIT_CARD_NUMBER", nullable = false)
    private String purchasedCreditCardNumber;

    @NotNull(message = "isCancelled field cannot be null.")
    @Column(name = "IS_CANCELLED", nullable = false)
    private Boolean isCancelled;

    public Ticket() {
        ticketNumber = UUID.randomUUID().toString();
        isCancelled = false;
    }

}
