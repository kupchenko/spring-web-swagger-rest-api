package me.kupchenko.service;

import lombok.RequiredArgsConstructor;
import me.kupchenko.exception.CourseNotFoundException;
import me.kupchenko.model.Course;
import me.kupchenko.model.CourseDto;
import me.kupchenko.model.CoursesDto;
import me.kupchenko.model.StudentDto;
import me.kupchenko.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final Storage storage;

    public Course createCourse(CourseDto courseDto) {
        Course course = mapToCourse(courseDto);
        storage.save(course);
        return course;
    }

    private Course mapToCourse(CourseDto studentDto) {
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
                    List<StudentDto> students = course.getStudents().stream()
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
