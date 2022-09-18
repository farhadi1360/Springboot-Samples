package org.edu.farhadi.simplerelational.database.repository;

import org.edu.farhadi.simplerelational.database.entities.CompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends BaseRepository<CompanyEntity, Long> {

    Page<CompanyEntity> findByParentId(Long parentId, Pageable pageable);
}