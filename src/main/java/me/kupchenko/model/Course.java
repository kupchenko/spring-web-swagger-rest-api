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
    private Integer enrollmentYear;
    private List<String> students;

    public void addStudent(Long studentId) {
        students.add(String.valueOf(studentId));
    }
}
