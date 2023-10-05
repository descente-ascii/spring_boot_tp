package com.taa.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.taa.app.domain.Teacher;
import com.taa.app.dto.TeacherDTO;

@Mapper
public interface TeacherMapper {

        TeacherMapper MAPPER = Mappers.getMapper(TeacherMapper.class);

        // Teacher Mapper
    @Mapping(target = "teacherName", source = "entity.name")
    @Mapping(target = "teacherLaboratory", source = "entity.laboratory")
    TeacherDTO teacherToTeacherDTO(Teacher entity);

    @Mapping(target = "name", source = "teacherName")
    @Mapping(target = "laboratory", source = "teacherLaboratory")
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "appointments",ignore = true)
    Teacher teacherDTOToTeacher(TeacherDTO entity);

}
