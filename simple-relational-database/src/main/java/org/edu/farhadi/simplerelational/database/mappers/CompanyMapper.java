package org.edu.farhadi.simplerelational.database.mappers;

import org.edu.farhadi.simplerelational.database.entities.CompanyEntity;
import org.edu.farhadi.simplerelational.database.entities.StationEntity;
import org.edu.farhadi.simplerelational.database.models.CompanyModel;
import org.edu.farhadi.simplerelational.database.models.StationModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {CompanyMapper.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CompanyMapper extends BaseMapper<CompanyModel, CompanyEntity> {

    @Override
    @Mappings({
            @Mapping(target = "parent.stationList", ignore = true),
            @Mapping(target = "stationList", qualifiedByName = "stationEntityToStationModel")
    })
    CompanyModel toModel(final CompanyEntity entity);

    @Named("stationEntityToStationModel")
    @Mapping(target = "company", ignore = true)
    StationModel stationEntityToStationModel(StationEntity entity);
}
