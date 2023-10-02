package mapper;

import domain.Appointment;
import domain.Student;
import domain.Teacher;
import dto.DtoAppointment;
import dto.StudentDTO;
import dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EntityMapper {

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
