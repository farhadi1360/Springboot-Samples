package org.edu.farhadi.simplerelational.database.services.impl;

import com.querydsl.core.types.Predicate;
import org.edu.farhadi.simplerelational.database.entities.LogicalDeleted;
import org.edu.farhadi.simplerelational.database.entities.StationEntity;
import org.edu.farhadi.simplerelational.database.entities.StudentEntity;
import org.edu.farhadi.simplerelational.database.mappers.BaseMapper;
import org.edu.farhadi.simplerelational.database.mappers.StudentMapper;
import org.edu.farhadi.simplerelational.database.models.StationModel;
import org.edu.farhadi.simplerelational.database.models.StudentModel;
import org.edu.farhadi.simplerelational.database.repository.BaseRepository;
import org.edu.farhadi.simplerelational.database.repository.StudentRepository;
import org.edu.farhadi.simplerelational.database.services.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentModel, StudentEntity, Long> implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
        this.studentRepository = studentRepository;
    }

    @Override
    public JpaRepository<StudentEntity, Long> getRepository() {
        return studentRepository;
    }

    @Override
    public Predicate queryBuilder(StudentModel filter) {
        return null;
    }
}
