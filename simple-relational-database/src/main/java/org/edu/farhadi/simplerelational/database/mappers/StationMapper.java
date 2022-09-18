package org.edu.farhadi.simplerelational.database.mappers;

import org.edu.farhadi.simplerelational.database.entities.StationEntity;
import org.edu.farhadi.simplerelational.database.models.StationModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {StationMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface StationMapper extends BaseMapper<StationModel, StationEntity> {

    @Override
    @Mappings({
            @Mapping(target = "company.stationList", ignore = true),
            @Mapping(target = "company.parent", ignore = true)
    })
    StationModel toModel(final StationEntity entity);
}
