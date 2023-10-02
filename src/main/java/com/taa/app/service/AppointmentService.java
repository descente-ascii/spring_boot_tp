package com.taa.app.service;

import com.taa.app.exceptionManager.ResourceNotFoundException;
import com.taa.app.dao.DaoAppointment;
import com.taa.app.domain.Appointment;
import com.taa.app.dto.DtoAppointment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taa.app.mapper.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    @Autowired
    private DaoAppointment daoAppointment;

    public DtoAppointment createAppointment(DtoAppointment dtoAppointment){
        System.out.println("---------------------" + dtoAppointment.getStudentId());
        Appointment appointment = EntityMapper.MAPPER.appointmentDTOToAppointment(dtoAppointment);
        Appointment savedAppointment = daoAppointment.save(appointment);
        return EntityMapper.MAPPER.appointmentToAppointmentDTO(savedAppointment);
    }

    public DtoAppointment getAppointmentById(Long appointmentId){
        Appointment appointment = daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: " + appointmentId)
        );
        return EntityMapper.MAPPER.appointmentToAppointmentDTO(appointment);
    }

    public void deleteAppointment(Long appointmentId){
        daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: " + appointmentId)
        );
        daoAppointment.deleteById(appointmentId);
    }

    public List<DtoAppointment> getAllAppointments(){
        List<Appointment> appointments = daoAppointment.findAll();
        return appointments.stream().map((appointment) -> EntityMapper.MAPPER.appointmentToAppointmentDTO(appointment))
                .collect(Collectors.toList());
    }

    public DtoAppointment updateAppointment(Long appointmentId, DtoAppointment updatedAppointment){
        Appointment appointment = daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: "+ appointmentId)
        );
        appointment.setDate(updatedAppointment.getDate());
        /*appointment.setStudent(updatedAppointment.getStudentId());
        appointment.setTeacher(updatedAppointment.getTeacherId());*/
        Appointment savedAppointment = daoAppointment.save(appointment);
        return EntityMapper.MAPPER.appointmentToAppointmentDTO(savedAppointment);
    }
}
