package me.kupchenko.controller.impl;

import lombok.RequiredArgsConstructor;
import me.kupchenko.controller.SwaggerCourseController;
import me.kupchenko.model.Course;
import me.kupchenko.model.CourseDto;
import me.kupchenko.model.CoursesDto;
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

    public Course getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    public ResponseEntity deleteCourseById(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.ok().build();
    }

    public Course createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }
}
