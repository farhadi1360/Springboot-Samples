package org.edu.farhadi.simplerelational.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Mostafa Farhadi
 * @email farhadi.kam@gmail.com
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Audited
public abstract class BaseEntity<ID extends Serializable> implements Serializable {

    @JsonIgnore
    @CreatedBy
    @Column(name = "created_by",updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(name = "created_date",updatable = false)
    protected Date createdDate;

    @JsonIgnore
    @LastModifiedBy
    @Column(name = "modified_by")
    protected String modifiedBy;

    @JsonIgnore
    @LastModifiedDate
    @Column(name = "modified_date")
    protected Date modifiedDate;

    @Version
    @Column(columnDefinition = "integer default 0")
    protected int version;


}
