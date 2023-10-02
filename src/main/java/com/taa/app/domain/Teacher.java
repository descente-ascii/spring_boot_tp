package com.taa.app.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher extends Person {

    private String laboratory;
    private List<Appointment> appointments = new ArrayList<Appointment>();

    public Teacher() {}

    public Teacher(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.PERSIST)
    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
