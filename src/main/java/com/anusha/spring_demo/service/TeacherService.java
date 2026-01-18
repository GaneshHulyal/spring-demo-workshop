package com.anusha.spring_demo.service;

import com.anusha.spring_demo.dto.TeacherResponse;
import com.anusha.spring_demo.model.Teacher;
import com.anusha.spring_demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public TeacherResponse addTeacher(Teacher teacher){
        return new TeacherResponse("Teacher added successfully!",teacherRepository.save(teacher));
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher deleteTeacherById(Long id){
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(Objects.nonNull(teacher)){
            teacherRepository.deleteById(id);
            return teacher;
        } else {
            return null;
        }
    }

    public TeacherResponse updateTeacher(Teacher teacher){
        Teacher updated = teacherRepository.save(teacher);
        return new TeacherResponse("Teacher updated successfully!", updated);
    }
}
