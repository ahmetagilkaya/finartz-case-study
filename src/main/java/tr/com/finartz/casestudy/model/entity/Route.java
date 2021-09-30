package tr.com.finartz.casestudy.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "ROUTES", uniqueConstraints={
        @UniqueConstraint(columnNames={"ROUTE_NAME", "FROM_AIRPORT_ID", "TO_AIRPORT_ID"})
})
@SequenceGenerator(sequenceName = "routes_seq", allocationSize = 1, name = "my_seq_gen")
public class Route extends BaseEntity {

    @NotBlank(message = "routeName field cannot be null or empty.")
    @Column(name = "ROUTE_NAME", nullable = false)
    private String routeName;

    @NotNull(message = "from field cannot be null or empty.")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "FROM_AIRPORT_ID")
    private Airport from;

    @NotNull(message = "to field cannot be null or empty.")
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "TO_AIRPORT_ID")
    private Airport to;

}
