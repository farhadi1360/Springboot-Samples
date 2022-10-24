package org.edu.farhadi.simplerelational.database.mappers;

import org.edu.farhadi.simplerelational.database.entities.CompanyEntity;
import org.edu.farhadi.simplerelational.database.entities.StationEntity;
import org.edu.farhadi.simplerelational.database.models.CompanyModel;
import org.edu.farhadi.simplerelational.database.models.StationModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {StationMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StationMapper extends BaseMapper<StationModel, StationEntity> {

    @Override
    @Mapping(target = "company.stationList", ignore = true)
    StationModel toModel(final StationEntity entity);



}