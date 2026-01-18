package com.ganesh.spring_demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_Name", nullable = false)
    private String teacher_Name;

    @Column(unique = true, name = "email_Address")
    private String email_Address;

    @Column(nullable = true)
    private String subject;

    public Teacher() {
    }

    public Teacher(Long id, String teacher_Name, String subject, String email_Address) {
        this.id = id;
        this.teacher_Name = teacher_Name;
        this.subject = subject;
        this.email_Address = email_Address;
    }

    public String getEmail_Address() {
        return email_Address;
    }

    public void setEmail_Address(String email_Address) {
        this.email_Address = email_Address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacher_Name() {
        return teacher_Name;
    }

    public void setTeacher_Name(String teacher_Name) {
        this.teacher_Name = teacher_Name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
