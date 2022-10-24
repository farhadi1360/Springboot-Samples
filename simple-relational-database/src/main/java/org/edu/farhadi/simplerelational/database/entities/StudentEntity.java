package org.edu.farhadi.simplerelational.database.entities;

import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "tbl_student")
@Audited
@Where(clause = "deleted=false")
public class StudentEntity extends BaseEntity<Long> implements LogicalDeleted{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_student", sequenceName = "seq_student", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student")
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private int age;
    private String family;
    private String address;
    private boolean deleted;
}
