package me.kupchenko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CoursesDto {
    private List<CourseDto> courses;
}
