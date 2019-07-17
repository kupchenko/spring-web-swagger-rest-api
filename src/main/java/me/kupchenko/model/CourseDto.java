package me.kupchenko.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CourseDto {
    private String name;
    private String room;
    private List<String> subjects;
    private String enrollmentYear;
    private List<StudentDto> students;
}
