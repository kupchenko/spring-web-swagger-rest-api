package me.kupchenko.controller.impl;

import lombok.RequiredArgsConstructor;
import me.kupchenko.controller.SwaggerCourseController;
import me.kupchenko.dto.CourseDto;
import me.kupchenko.dto.CourseDtoRequest;
import me.kupchenko.dto.CoursesDto;
import me.kupchenko.model.Course;
import me.kupchenko.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourseController implements SwaggerCourseController {
    private final CourseService courseService;

    public CoursesDto getCourses() {
        return courseService.getCourses();
    }

    public CourseDto getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    public ResponseEntity deleteCourseById(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.ok().build();
    }

    public Course createCourse(@RequestBody CourseDtoRequest courseDto) {
        return courseService.createCourse(courseDto);
    }

    @Override
    public CourseDto addStudentToCourse(Long courseId, Long studentId) {
        return courseService.addStudentToCourse(courseId, studentId);
    }
}
