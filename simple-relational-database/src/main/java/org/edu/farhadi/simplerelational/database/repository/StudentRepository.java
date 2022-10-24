package org.edu.farhadi.simplerelational.database.repository;

import org.edu.farhadi.simplerelational.database.entities.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BaseRepository<StudentEntity, Long>{
}
