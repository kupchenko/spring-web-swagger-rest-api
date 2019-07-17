package me.kupchenko.service;

import lombok.RequiredArgsConstructor;
import me.kupchenko.exception.CourseNotFoundException;
import me.kupchenko.model.Course;
import me.kupchenko.model.CourseDto;
import me.kupchenko.model.Courses;
import me.kupchenko.storage.Storage;
import org.springframework.stereotype.Service;

import java.util.Random;

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
                .enrollmentYear(Short.valueOf(studentDto.getEnrollmentYear()))
                .subjects(studentDto.getSubjects())
                .build();

    }

    public Courses getCourses() {
        return new Courses(storage.getCourses());
    }

    public Course getCourseById(Long courseId) {
        return storage.getCourseById(courseId).orElseThrow(CourseNotFoundException::new);
    }

    public void deleteCourseById(Long courseId) {
        storage.deleteCourseById(courseId);
    }
}
