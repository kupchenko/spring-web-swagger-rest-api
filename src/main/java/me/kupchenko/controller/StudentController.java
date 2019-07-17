package me.kupchenko.controller;

import lombok.RequiredArgsConstructor;
import me.kupchenko.model.Student;
import me.kupchenko.model.StudentDto;
import me.kupchenko.model.Students;
import me.kupchenko.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public Students getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{studId}")
    public Student getStudentById(@PathVariable Long studId) {
        return studentService.getStudentById(studId);
    }

    @DeleteMapping("/{studId}")
    public ResponseEntity deleteStudentById(@PathVariable Long studId) {
        studentService.deleteStudentById(studId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public Student createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @PutMapping("/{studId}")
    public Student createStudent(@PathVariable Long studId, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studId, studentDto);
    }
}
