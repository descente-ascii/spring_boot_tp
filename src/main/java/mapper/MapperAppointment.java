package mapper;

import domain.Appointment;
import domain.Department;
import dto.DtoAppointment;

public class MapperAppointment {

    // Convert department jpa entity into department dto
    public static DtoAppointment mapToAppointmentDto(Appointment appointment){
        return new DtoAppointment(
                appointment.getId(),
                appointment.getDate(),
                appointment.getStudent(),
                appointment.getTeacher()
        );
    }

    // convert department dto into department jpa entity
    public static Appointment mapToAppointment(DtoAppointment appointmentDto){
        return new Appointment(
                appointmentDto.getDate(),
                appointmentDto.getStudent(),
                appointmentDto.getTeacher()
        );
    }
}
