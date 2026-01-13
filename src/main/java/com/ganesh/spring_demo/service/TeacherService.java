package com.ganesh.spring_demo.service;

import com.ganesh.spring_demo.dto.StudentResponse;
import com.ganesh.spring_demo.model.Teacher;
import com.ganesh.spring_demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setTeacherName(teacherDetails.getTeacherName());
            teacher.setEmailAddress(teacherDetails.getEmailAddress());
            teacher.setSubject(teacherDetails.getSubject());
            return teacherRepository.save(teacher);
        }
        return null;
    }

    public boolean deleteTeacherById(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}