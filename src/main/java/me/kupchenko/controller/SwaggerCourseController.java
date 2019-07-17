package me.kupchenko.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.kupchenko.dto.CourseDto;
import me.kupchenko.dto.CourseDtoRequest;
import me.kupchenko.dto.CoursesDto;
import me.kupchenko.model.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Api(value = "Course",
        description = "Data manipulation endpoints for 'Course'")
@RequestMapping("/course")
public interface SwaggerCourseController {
    @ApiOperation(value = "View courses info", response = CoursesDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully retrieved CoursesDto info")
    }
    )
    @GetMapping()
    CoursesDto getCourses();

    @ApiOperation(value = "View Course info", response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully retrieved Course info"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                    message = "No course found with given id")
    }
    )
    @GetMapping("/{courseId}")
    CourseDto getCourseById(@PathVariable Long courseId);

    @ApiOperation(value = "Delete Course info")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully deleted Course info"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                    message = "No course found with given id")
    }
    )
    @DeleteMapping("/{courseId}")
    ResponseEntity deleteCourseById(@PathVariable Long courseId);

    @ApiOperation(value = "Create Course", response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_CREATED,
                    message = "Successfully deleted Course info"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST,
                    message = "Request body is invalid")
    }
    )
    @PostMapping()
    Course createCourse(@RequestBody CourseDtoRequest courseDto);
}
