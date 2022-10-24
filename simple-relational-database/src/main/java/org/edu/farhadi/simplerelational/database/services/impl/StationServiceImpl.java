package org.edu.farhadi.simplerelational.database.services.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.edu.farhadi.simplerelational.database.entities.QStationEntity;
import org.edu.farhadi.simplerelational.database.entities.StationEntity;
import org.edu.farhadi.simplerelational.database.enums.DistanceType;
import org.edu.farhadi.simplerelational.database.mappers.StationMapper;
import org.edu.farhadi.simplerelational.database.models.CompanyModel;
import org.edu.farhadi.simplerelational.database.models.StationModel;
import org.edu.farhadi.simplerelational.database.repository.StationRepository;
import org.edu.farhadi.simplerelational.database.services.StationService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.edu.farhadi.simplerelational.database.utils.DistanceUtil.distance;
import static org.edu.farhadi.simplerelational.database.utils.MapperHelper.option;


@Service
public class StationServiceImpl extends BaseServiceImpl<StationModel, StationEntity, Long> implements StationService {

    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository repository, StationMapper mapper) {
        super(repository, mapper);
        this.stationRepository = repository;
    }

    @Override
    public JpaRepository<StationEntity,Long> getRepository() {
        return stationRepository;
    }

    @Override
    public Predicate queryBuilder(StationModel filter) {
        BooleanBuilder builder = new BooleanBuilder();
        QStationEntity path = QStationEntity.stationEntity;

        option(() -> filter.getId())
                .ifPresent(id -> builder.and(path.id.eq(id)));
        option(() -> filter.getLatitude())
                .ifPresent(latitude -> builder.and(path.latitude.eq(latitude)));
        option(() -> filter.getLongitude())
                .ifPresent(longitude -> builder.and(path.longitude.eq(longitude)));
        option(() -> filter.getCompany().getId())
                .ifPresent(companyId -> builder.and(path.company.id.eq(companyId)));
        if (StringUtils.hasText(filter.getName()))
            builder.and(path.name.contains(filter.getName()));

        return builder;
    }

    @Override
    public List<StationModel> findAllByLocation(Long companyId, double latitude, double longitude) {
        StationModel filter = new StationModel(){
            {
                setCompany(new CompanyModel(){{setId(companyId);}});

            }
        };
        return StreamSupport.stream(stationRepository.findAll(queryBuilder(filter)).spliterator(), false)
                .map(entity -> {
                    StationModel model = mapper.toModel(entity);
                    model.setDistance(distance(latitude, longitude, model.getLatitude(), model.getLongitude(), DistanceType.Kilometers));
                    return model;
                })
                .sorted(Comparator.comparing(StationModel::getDistance))
                .collect(Collectors.toList());
    }
}
