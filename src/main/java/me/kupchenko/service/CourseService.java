package me.kupchenko.service;

import lombok.RequiredArgsConstructor;
import me.kupchenko.dto.CourseDto;
import me.kupchenko.dto.CourseDtoRequest;
import me.kupchenko.dto.CoursesDto;
import me.kupchenko.dto.StudentDto;
import me.kupchenko.exception.CourseNotFoundException;
import me.kupchenko.model.Course;
import me.kupchenko.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final Storage storage;

    public Course createCourse(CourseDtoRequest courseDto) {
        Course course = mapToCourse(courseDto);
        storage.save(course);
        return course;
    }

    private Course mapToCourse(CourseDtoRequest studentDto) {
        Random random = new Random();
        return Course.builder()
                .id(random.nextLong())
                .name(studentDto.getName())
                .room(Integer.valueOf(studentDto.getRoom()))
                .enrollmentYear(Integer.valueOf(studentDto.getEnrollmentYear()))
                .subjects(studentDto.getSubjects())
                .build();

    }

    public CoursesDto getCourses() {
        List<CourseDto> coursesDtos = storage.getCourses().stream()
                .map(course -> {
                    List<StudentDto> students;
                    if (course.getStudents() != null) {
                        students = course.getStudents().stream()
                                .map(Long::valueOf)
                                .map(storage::getStudentById)
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .map(student ->
                                        StudentDto.builder()
                                                .email(student.getEmail())
                                                .dateOfBirth(student.getDateOfBirth())
                                                .lastName(student.getLastName())
                                                .firstName(student.getFirstName())
                                                .build()
                                ).collect(Collectors.toList());
                    } else {
                        students = new ArrayList<>();
                    }
                    return CourseDto.builder()
                            .name(course.getName())
                            .enrollmentYear(String.valueOf(course.getEnrollmentYear()))
                            .room(String.valueOf(course.getRoom()))
                            .subjects(course.getSubjects())
                            .students(students)
                            .build();
                })
                .collect(Collectors.toList());
        return new CoursesDto(coursesDtos);
    }

    public Course getCourseById(Long courseId) {
        return storage.getCourseById(courseId).orElseThrow(CourseNotFoundException::new);
    }

    public void deleteCourseById(Long courseId) {
        storage.deleteCourseById(courseId);
    }
}
