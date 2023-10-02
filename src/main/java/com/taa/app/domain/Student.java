package com.taa.app.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {

    private int studentNumber;

    private List<Appointment> appointments = new ArrayList<Appointment>();

    public Student() {}

    public Student(int studentNumber){
        this.studentNumber = studentNumber;
    }


    public int getStudentNumber(){
        return studentNumber;
    }

    public void setStudentNumber(int setStudentNumber){
        this.studentNumber = setStudentNumber;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
