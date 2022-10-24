package org.edu.farhadi.simplerelational.database.services;

import org.edu.farhadi.simplerelational.database.models.StudentModel;

public interface StudentService extends BaseService<StudentModel, Long> , LogicalDeletedService<Long>{
}
