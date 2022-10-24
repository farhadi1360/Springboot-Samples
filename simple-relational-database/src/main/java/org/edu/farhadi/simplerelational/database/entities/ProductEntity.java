package org.edu.farhadi.simplerelational.database.entities;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "product")
@Table(name = "tbl_product")
@Audited
@Where(clause = "deleted=false")
public class ProductEntity extends BaseEntity<Long> implements LogicalDeleted{

    @Id
    @SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    private Long id;
    @NotNull
    private int code;
    @NotNull
    private String title;
    private String description;
    private String owner;
    private boolean deleted;


}
