package org.edu.farhadi.simplerelational.database.entities;
/**
 * @author Mostafa Farhadi
 * @email farhadi.kam@gmail.com
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_company")
@Audited
@Where(clause = "deleted=false")
public class CompanyEntity extends BaseEntity<Long> implements LogicalDeleted {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_company", sequenceName = "seq_company", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_company")
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_company_id")
    private CompanyEntity parent;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<StationEntity> stationList;

    private boolean deleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_company_product", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<ProductEntity> products;
}