package com.pulse.studentits.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_account", schema = "studentits")
public class StudentAccount {
    @Id
    @Column(name = "student_id", nullable = false, length = 50)
    private String studentId;

    @Column(name = "personal_no", nullable = false, length = 20)
    private String personalNo;

    //Constructors
    public StudentAccount() {
    }

    public StudentAccount(String studentId, String personalNo) {
        this.studentId = studentId;
        this.personalNo = personalNo;
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPersonalNo() {
        return personalNo;
    }

    public void setPersonalNo(String personalNo) {
        this.personalNo = personalNo;
    }
}