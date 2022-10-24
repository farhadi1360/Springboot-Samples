package org.edu.farhadi.simplerelational.database.entities;
/**
 * @author Mostafa Farhadi
 * @email farhadi.kam@gmail.com
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "company")
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



    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade =CascadeType.ALL)
    private List<StationEntity> stationList;

    private boolean deleted;

//    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
//    @JoinTable(name = "tbl_company_product", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private Set<ProductEntity> products;
}