package com.ganesh.spring_demo.controller;

import com.ganesh.spring_demo.model.Teacher;
import com.ganesh.spring_demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
}