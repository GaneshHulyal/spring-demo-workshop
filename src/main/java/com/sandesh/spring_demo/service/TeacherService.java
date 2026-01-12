package com.sandesh.spring_demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sandesh.spring_demo.dto.TeacherResponse;
import com.sandesh.spring_demo.model.Teacher;
import com.sandesh.spring_demo.repository.TeacherRepository;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<TeacherResponse> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(t -> new TeacherResponse(
                        t.getId(),
                        t.getName(),
                        t.getSubject(),
                        t.getEmail(),
                        t.getPhone()))
                .collect(Collectors.toList());
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher existing = teacherRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(teacher.getName());
        existing.setEmail(teacher.getEmail());
        existing.setSubject(teacher.getSubject());
        existing.setPhone(teacher.getPhone());

        return teacherRepository.save(existing);
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
