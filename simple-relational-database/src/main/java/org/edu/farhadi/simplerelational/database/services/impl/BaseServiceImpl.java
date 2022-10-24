package org.edu.farhadi.simplerelational.database.services.impl;

import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.edu.farhadi.simplerelational.database.entities.BaseEntity;
import org.edu.farhadi.simplerelational.database.exceptions.EntityNotFoundException;
import org.edu.farhadi.simplerelational.database.mappers.BaseMapper;
import org.edu.farhadi.simplerelational.database.models.BaseModel;
import org.edu.farhadi.simplerelational.database.repository.BaseRepository;
import org.edu.farhadi.simplerelational.database.services.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<M extends BaseModel<ID>, E extends BaseEntity<ID>, ID extends Serializable> implements BaseService<M, ID> {

    public final BaseRepository<E, ID> repository;
    public final BaseMapper<M, E> mapper;
    public abstract Predicate queryBuilder(M filter);

    @Override
    @Transactional(readOnly = true)
    public Page<M> findAll(M filter, Pageable pageable) {
        return repository.findAll(queryBuilder(filter), pageable).map(mapper::toModel);
    }

    @Override
    @Transactional(readOnly = true)
    public Long countAll(M filter) {
        return repository.count(queryBuilder(filter));
    }

    @Override
    @Transactional(readOnly = true)
    public M findById(ID id) {
        E entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("id: " + id));
        return mapper.toModel(entity);
    }

    @Override
    public M save(M model) {
        if (Objects.nonNull(model.getId())) {
            E entity = repository.findById(model.getId()).orElseThrow(() -> new EntityNotFoundException("id: " + model.getId()));
            E updatedEntity = mapper.updateEntity(model, entity);
            return mapper.toModel(repository.save(updatedEntity));
        }

        return mapper.toModel(repository.save(mapper.toEntity(model)));
    }



    @Override
    public void deleteById(ID id) {
        E entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("id: " + id));
        repository.delete(entity);
    }
}
