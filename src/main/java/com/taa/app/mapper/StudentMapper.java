package com.taa.app.mapper;

import com.taa.app.domain.Student;
import com.taa.app.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class);

    // Student Mapper
    @Mapping(target = "studentName", source = "entity.name")
    @Mapping(target = "studentNumber", source = "entity.studentNumber")
    StudentDTO studentToStudentDTO(Student entity);

    @Mapping(target = "name", source = "studentName")
    @Mapping(target = "studentNumber", source = "studentNumber")
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "appointments",ignore = true)
    Student studentDTOToStudent(StudentDTO entity);

}
