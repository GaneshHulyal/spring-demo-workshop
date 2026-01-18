package com.ganesh.spring_demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.spring_demo.model.Course;
import com.ganesh.spring_demo.model.Teacher;
import com.ganesh.spring_demo.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(teacher);
        }
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok().body(createdTeacher);
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long id, @RequestBody Teacher teacherDetails) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacherDetails);
        if (updatedTeacher == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(updatedTeacher);
        }
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable("id") Long id) {
        boolean deleted = teacherService.deleteTeacherById(id);
        if (deleted) {
            return ResponseEntity.ok().body("Teacher deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/teacher/{id}/courses")
    public ResponseEntity<List<Course>> getCoursesByTeacherId(@PathVariable("id") Long id) {
        List<Course> courses = teacherService.getCoursesByTeacherId(id);
        return ResponseEntity.ok().body(courses);
    }
}