package com.taa.app.dto;



import java.sql.Date;


public class AppointmentDTO {
    private Date date;
    private long studentId;
    private long teacherId;

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
