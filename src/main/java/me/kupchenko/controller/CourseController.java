package me.kupchenko.controller;

import lombok.RequiredArgsConstructor;
import me.kupchenko.model.Course;
import me.kupchenko.model.CourseDto;
import me.kupchenko.model.Courses;
import me.kupchenko.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("/")
    public Courses getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity deleteCourseById(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody CourseDto courseDto) {
        return courseService.createCourse(courseDto);
    }
}
