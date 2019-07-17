package me.kupchenko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private String name;
    private String room;
    private List<String> subjects;
    private String enrollmentYear;
    private List<StudentDto> students;
}
