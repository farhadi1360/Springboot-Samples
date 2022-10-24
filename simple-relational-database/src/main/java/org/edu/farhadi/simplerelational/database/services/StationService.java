package org.edu.farhadi.simplerelational.database.services;


import org.edu.farhadi.simplerelational.database.models.StationModel;

import java.util.List;

public interface StationService extends BaseService<StationModel, Long> , LogicalDeletedService<Long> {
    List<StationModel> findAllByLocation(Long companyId, double latitude, double longitude);
}
