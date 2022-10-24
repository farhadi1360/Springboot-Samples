package org.edu.farhadi.simplerelational.database.services;

import org.edu.farhadi.simplerelational.database.entities.LogicalDeleted;
import org.edu.farhadi.simplerelational.database.exceptions.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import java.io.Serializable;

public interface LogicalDeletedService<ID extends Serializable> {
    <E extends LogicalDeleted> JpaRepository<E, ID> getRepository();

    default void logicalDeleteById(ID id) {
        var entity = getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException("id: " + id));
        entity.setDeleted(true);
        getRepository().save(entity);
    }
}