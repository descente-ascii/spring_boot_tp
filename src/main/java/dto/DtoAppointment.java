package dto;

import domain.Student;
import domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoAppointment {
    private Date date;
    private long studentId;
    private long teacherId;
}
