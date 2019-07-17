package me.kupchenko.service;

import lombok.RequiredArgsConstructor;
import me.kupchenko.exception.StudentNotFoundException;
import me.kupchenko.model.Student;
import me.kupchenko.dto.StudentDto;
import me.kupchenko.model.Students;
import me.kupchenko.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final Storage storage;

    public Student getStudentById(Long studId) {
        return storage.getStudentById(studId).orElseThrow(StudentNotFoundException::new);
    }

    public Students getStudents() {
        return new Students(storage.getStudents());
    }

    public Student createStudent(StudentDto studentDto) {
        Student student = mapToStudent(studentDto);
        storage.save(student);
        return student;
    }

    private Student mapToStudent(StudentDto studentDto) {
        Random random = new Random();
        return Student.builder()
                .id(random.nextLong())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .dateOfBirth(studentDto.getDateOfBirth())
                .email(studentDto.getEmail()).build();

    }

    public void deleteStudentById(Long studId) {
        storage.deleteStudentById(studId);
    }

    public Student updateStudent(Long studId, StudentDto studentDto) {
        Student student = storage.getStudentById(studId).orElseThrow(StudentNotFoundException::new);
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        return student;
    }
}
