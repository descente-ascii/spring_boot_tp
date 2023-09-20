package Service;

import ExceptionManager.ResourceNotFoundException;
import dao.DaoAppointment;
import domain.Appointment;
import dto.DtoAppointment;
import lombok.AllArgsConstructor;
import mapper.MapperAppointment;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService {

    private DaoAppointment daoAppointment;

    public DtoAppointment createAppointment(DtoAppointment dtoAppointment){
        Appointment appointment = MapperAppointment.mapToAppointment(dtoAppointment);
        Appointment savedAppointment = daoAppointment.save(appointment);
        return MapperAppointment.mapToAppointmentDto(savedAppointment);
    }

    public DtoAppointment getAppointmentById(Long appointmentId){
        //TODO retourner une erreur
        Appointment appointment = daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint is not exists with a given id: " + appointmentId)
        );
        return MapperAppointment.mapToAppointmentDto(appointment);
    }

    public void deleteAppointment(Long appointmentId){
        daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint is not exists with a given id:"+ appointmentId)
        );
        daoAppointment.deleteById(appointmentId);
    }

    public List<DtoAppointment> getAllAppointments(){
        List<Appointment> appointments = daoAppointment.findAll();
        return appointments.stream().map((appointment) -> MapperAppointment.mapToAppointmentDto(appointment))
                .collect(Collectors.toList());
    }

    public DtoAppointment updateAppointment(Long appointmentId, DtoAppointment updatedAppointment){
        Appointment appointment = daoAppointment.findById(appointmentId).orElseThrow(
                () -> new ResourceNotFoundException("Appoint is not exists with a given id:"+ appointmentId)
        );
        appointment.setDate(updatedAppointment.getDate());
        appointment.setStudent(updatedAppointment.getStudent());
        appointment.setTeacher(updatedAppointment.getTeacher());
        Appointment savedAppointment = daoAppointment.save(appointment);
        return MapperAppointment.mapToAppointmentDto(savedAppointment);
    }
}
