package org.edu.farhadi.simplerelational.database.services;

import org.edu.farhadi.simplerelational.database.models.CompanyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompanyService extends BaseService<CompanyModel, Long> , LogicalDeletedService<Long> {

}
