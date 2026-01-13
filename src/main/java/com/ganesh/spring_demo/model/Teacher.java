package com.ganesh.spring_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacherName", nullable = false)
    private String teacherName;

    @Column(unique = true, name = "emailAddress")
    private String emailAddress;

    @Column(nullable = true)
    private String subject;

    public Teacher() {
    }

    public Teacher(Long id, String teacherName, String subject, String emailAddress) {
        this.id = id;
        this.teacherName = teacherName;
        this.subject = subject;
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}