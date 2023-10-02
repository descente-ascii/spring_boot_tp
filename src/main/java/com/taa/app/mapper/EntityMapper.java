package com.taa.app.mapper;

import com.taa.app.domain.Appointment;
import com.taa.app.domain.Student;
import com.taa.app.domain.Teacher;
import com.taa.app.dto.DtoAppointment;
import com.taa.app.dto.StudentDTO;
import com.taa.app.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityMapper {

    EntityMapper MAPPER = Mappers.getMapper(EntityMapper.class);

    // Appointment Mapper
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "teacherId", source = "teacher.id")
    DtoAppointment appointmentToAppointmentDTO(Appointment entity);

    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "teacher.id", source = "teacherId")
    Appointment appointmentDTOToAppointment(DtoAppointment dto);


    // Teacher Mapper
    @Mapping(target = "teacherName", source = "entity.name")
    @Mapping(target = "teacherLaboratory", source = "entity.laboratory")
    TeacherDTO teacherToTeacherDTO(Teacher entity);

    @Mapping(target = "entity.name", source = "teacherName")
    @Mapping(target = "entity.laboratory", source = "teacherLaboratory")
    Teacher teacherDTOToTeacher(TeacherDTO entity);


    // Student Mapper
    @Mapping(target = "teacherName", source = "entity.name")
    @Mapping(target = "teacherLaboratory", source = "entity.laboratory")
    StudentDTO teacherToTeacherDTO(Student entity);

    @Mapping(target = "entity.name", source = "teacherName")
    @Mapping(target = "entity.laboratory", source = "teacherLaboratory")
    Student teacherDTOToTeacher(StudentDTO entity);
}
