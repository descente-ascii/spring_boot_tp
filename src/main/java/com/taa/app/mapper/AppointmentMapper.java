package com.taa.app.mapper;

import com.taa.app.domain.Appointment;
import com.taa.app.dto.DtoAppointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {

    AppointmentMapper MAPPER = Mappers.getMapper(AppointmentMapper.class);

    // Appointment Mapper
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "teacherId", source = "teacher.id")
    DtoAppointment appointmentToAppointmentDTO(Appointment entity);

    @Mapping(target = "student.id", source = "studentId")
    @Mapping(target = "teacher.id", source = "teacherId")
    @Mapping(target = "id",ignore = true)
    Appointment appointmentDTOToAppointment(DtoAppointment dto);





}
