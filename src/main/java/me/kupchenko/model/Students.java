package me.kupchenko.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Students {
    private List<Student> students;
}
