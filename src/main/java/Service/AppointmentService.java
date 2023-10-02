package Service;

import ExceptionManager.ResourceNotFoundException;
import dao.DaoAppointment;
import domain.Appointment;
import dto.DtoAppointment;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import mapper.EntityMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DaoAppointment daoAppointment;
    private final EntityMapper entityMapper;

    public DtoAppointment createAppointment(DtoAppointment dtoAppointment){
        Appointment appointment = entityMapper.appointmentDTOToAppointment(dtoAppointment);
        Appointment savedAppointment = daoAppointment.save(appointment);
        return entityMapper.appointmentToAppointmentDTO(savedAppointment);
    }

    public DtoAppointment getAppointmentById(Long appointmentId){
        Appointment appointment = daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: " + appointmentId)
        );
        return entityMapper.appointmentToAppointmentDTO(appointment);
    }

    public void deleteAppointment(Long appointmentId){
        daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint does not exist with the given id: " + appointmentId)
        );
        daoAppointment.deleteById(appointmentId);
    }

    public List<DtoAppointment> getAllAppointments(){
        List<Appointment> appointments = daoAppointment.findAll();
        return appointments.stream().map((appointment) -> entityMapper.appointmentToAppointmentDTO(appointment))
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
        return entityMapper.appointmentToAppointmentDTO(savedAppointment);
    }
}
