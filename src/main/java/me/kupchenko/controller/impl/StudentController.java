package me.kupchenko.controller.impl;

import lombok.RequiredArgsConstructor;
import me.kupchenko.controller.SwaggerStudentController;
import me.kupchenko.model.Student;
import me.kupchenko.dto.StudentDto;
import me.kupchenko.model.Students;
import me.kupchenko.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController implements SwaggerStudentController {

    private final StudentService studentService;

    public Students getStudents() {
        return studentService.getStudents();
    }

    public Student getStudentById(@PathVariable Long studId) {
        return studentService.getStudentById(studId);
    }

    public ResponseEntity deleteStudentById(@PathVariable Long studId) {
        studentService.deleteStudentById(studId);
        return ResponseEntity.ok().build();
    }

    public Student createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    public Student updateStudent(@PathVariable Long studId, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(studId, studentDto);
    }
}
