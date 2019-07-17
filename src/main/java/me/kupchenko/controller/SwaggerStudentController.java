package me.kupchenko.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import me.kupchenko.model.Student;
import me.kupchenko.model.StudentDto;
import me.kupchenko.model.Students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Api(value = "Student",
        description = "Data manipulation endpoints for 'Student'")
@RequestMapping("/student")
public interface SwaggerStudentController {

    @ApiOperation(value = "View Students info")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully retrieved Students info")
    }
    )
    @GetMapping
    Students getStudents();

    @ApiOperation(value = "View Student info")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully retrieved Student info"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                    message = "No Student found with given id")
    }
    )
    @GetMapping("/{studId}")
    Student getStudentById(@PathVariable Long studId);

    @ApiOperation(value = "Delete Student info")
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully deleted Student info"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                    message = "No Student found with given id")
    }
    )
    @DeleteMapping("/{studId}")
    ResponseEntity deleteStudentById(@PathVariable Long studId);

    @ApiOperation(value = "Create Student info", response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully created Student info")
    }
    )
    @PostMapping
    Student createStudent(@RequestBody StudentDto studentDto);

    @ApiOperation(value = "Update Student info", response = Student.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpServletResponse.SC_OK,
                    message = "Successfully updated Student info"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND,
                    message = "No student found with given id")
    }
    )
    @PutMapping("/{studId}")
    Student updateStudent(@PathVariable Long studId, @RequestBody StudentDto studentDto);
}
