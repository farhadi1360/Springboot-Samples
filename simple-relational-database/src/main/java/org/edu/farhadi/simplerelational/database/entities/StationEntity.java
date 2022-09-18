package org.edu.farhadi.simplerelational.database.entities;
/**
 * @author Mostafa Farhadi
 * @email farhadi.kam@gmail.com
 */
import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(name = "tbl_station")
@Audited
@Where(clause = "deleted=false")
public class StationEntity extends BaseEntity<Long> implements LogicalDeleted {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_station", sequenceName = "seq_station", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_station")
    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @Column(name = "lat", nullable = false)
    @NotNull
    @Min(value = -90)
    @Max(value = 90)
    private Double latitude;

    @Column(name = "lng", nullable = false)
    @NotNull
    @Min(value = -180)
    @Max(value = 180)
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;

    private boolean deleted;

}
