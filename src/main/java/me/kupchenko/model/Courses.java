package me.kupchenko.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Courses {
    private List<Course> courses;
}
