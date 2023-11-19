package com.taa.app.dto;

public class StudentDTO {
    private String studentName;
    private int studentNumber;

    public String getName() {
        return this.studentName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public int getStudentNumber() {
        return this.studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
