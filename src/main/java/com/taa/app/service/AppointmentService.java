package com.taa.app.service;

import com.taa.app.exceptionManager.ResourceNotFoundException;
import com.taa.app.mapper.AppointmentMapper;
import com.taa.app.dao.AppointmentDAO;
import com.taa.app.domain.Appointment;
import com.taa.app.dto.AppointmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentDAO appointmentDAO;

    public AppointmentDTO createAppointment(AppointmentDTO appointmentDTO){
        System.out.println("---------------------" + appointmentDTO.getStudentId());
        Appointment appointment = AppointmentMapper.MAPPER.appointmentDTOToAppointment(appointmentDTO);
        Appointment savedAppointment = appointmentDAO.save(appointment);
        return AppointmentMapper.MAPPER.appointmentToAppointmentDTO(savedAppointment);
    }

    public AppointmentDTO getAppointmentById(Long appointmentId){
        Appointment appointment = appointmentDAO.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: " + appointmentId)
        );
        return AppointmentMapper.MAPPER.appointmentToAppointmentDTO(appointment);
    }

    public void deleteAppointment(Long appointmentId){
        appointmentDAO.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: " + appointmentId)
        );
        appointmentDAO.deleteById(appointmentId);
    }

    public List<AppointmentDTO> getAllAppointments(){
        List<Appointment> appointments = appointmentDAO.findAll();
        return appointments.stream().map((appointment) -> AppointmentMapper.MAPPER.appointmentToAppointmentDTO(appointment))
                .collect(Collectors.toList());
    }

    public AppointmentDTO updateAppointment(Long appointmentId, AppointmentDTO updatedAppointment){
        Appointment appointment = appointmentDAO.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: "+ appointmentId)
        );
        appointment.setDate(updatedAppointment.getDate());
        /*appointment.setStudent(updatedAppointment.getStudentId());
        appointment.setTeacher(updatedAppointment.getTeacherId());*/
        Appointment savedAppointment = appointmentDAO.save(appointment);
        return AppointmentMapper.MAPPER.appointmentToAppointmentDTO(savedAppointment);
    }
}
