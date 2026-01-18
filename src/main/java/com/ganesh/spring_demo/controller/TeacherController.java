package com.ganesh.spring_demo.controller;

import com.anusha.spring_demo.dto.TeacherResponse;
import com.anusha.spring_demo.model.Teacher;
import com.anusha.spring_demo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // GET all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    // POST add teacher
    @PostMapping
    public TeacherResponse addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    // GET teacher by ID
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(teacher);
    }

    // DELETE teacher by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.deleteTeacherById(id);
        if (Objects.nonNull(teacher)) {
            return ResponseEntity.ok("Teacher deleted successfully!");
        }
        return ResponseEntity.notFound().build();
    }
}
