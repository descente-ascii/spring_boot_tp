package domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Appointment implements Serializable {

    private Long id;
    private Date date;
    private Student student;
    private Teacher teacher;

    public Appointment(){
    }

    public Appointment(Date date, Student student, Teacher teacher) {
        this.date = date;
        this.student = student;
        this.teacher = teacher;
    }

    @Id
    @GeneratedValue
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    @ManyToOne
    public Student getStudent() {
        return this.student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    public Teacher getTeacher(){return this.teacher;}

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
