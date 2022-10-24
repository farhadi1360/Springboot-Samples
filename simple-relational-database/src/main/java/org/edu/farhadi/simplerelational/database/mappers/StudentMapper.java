package org.edu.farhadi.simplerelational.database.mappers;

import org.edu.farhadi.simplerelational.database.entities.StudentEntity;
import org.edu.farhadi.simplerelational.database.models.StudentModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = {StudentMapper.class},
//        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", uses = StudentMapper.class,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper extends BaseMapper<StudentModel, StudentEntity> {
}
