package org.edu.farhadi.simplerelational.database.repository;

import org.edu.farhadi.simplerelational.database.entities.StationEntity;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StationRepository extends BaseRepository<StationEntity, Long> {
    List<StationEntity> findAllByCompanyId(long companyId);
}