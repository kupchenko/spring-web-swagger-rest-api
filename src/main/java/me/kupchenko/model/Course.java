package me.kupchenko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Course {
    private Long id;
    private String name;
    private Integer room;
    private List<String> subjects;
    private Short enrollmentYear;
    private List<String> students;
}