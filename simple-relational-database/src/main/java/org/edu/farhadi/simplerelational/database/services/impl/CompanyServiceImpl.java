package org.edu.farhadi.simplerelational.database.services.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.edu.farhadi.simplerelational.database.entities.CompanyEntity;
import org.edu.farhadi.simplerelational.database.entities.QCompanyEntity;
import org.edu.farhadi.simplerelational.database.exceptions.EntityNotFoundException;
import org.edu.farhadi.simplerelational.database.mappers.CompanyMapper;
import org.edu.farhadi.simplerelational.database.models.CompanyModel;
import org.edu.farhadi.simplerelational.database.repository.CompanyRepository;
import org.edu.farhadi.simplerelational.database.services.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

import static org.edu.farhadi.simplerelational.database.utils.MapperHelper.option;


@Service
public class CompanyServiceImpl extends BaseServiceImpl<CompanyModel, CompanyEntity, Long> implements CompanyService {
    private final CompanyRepository repository;
    private CompanyMapper mapper;

    public CompanyServiceImpl(CompanyRepository repository, CompanyMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public JpaRepository<CompanyEntity, Long> getRepository() {
        return repository;
    }

    @Override
    public CompanyModel save(CompanyModel model) {

        if (Objects.nonNull(model.getId())) {
            CompanyEntity entity = repository.findById(model.getId()).orElseThrow(() -> new EntityNotFoundException("id: " + model.getId()));
            CompanyEntity updatedEntity = mapper.updateEntity(model, entity);
            return mapper.toModel(repository.save(updatedEntity));
        }

        model.getStationList().stream().forEach(station ->{station.setCompany(model);});
        CompanyEntity companyEntity = mapper.toEntity(model);
        companyEntity.getStationList().stream().forEach(station -> {station.setCompany(companyEntity);
        });
        return mapper.toModel(repository.save(companyEntity));
    }


    @Override
    public Predicate queryBuilder(CompanyModel filter) {
        BooleanBuilder builder = new BooleanBuilder();
        QCompanyEntity path = QCompanyEntity.companyEntity;

        option(() -> filter.getId())
                .ifPresent(id -> builder.and(path.id.eq(id)));

        if (StringUtils.hasText(filter.getName()))
            builder.and(path.name.contains(filter.getName()));

        return builder;
    }


}
