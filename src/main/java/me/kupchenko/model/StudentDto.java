package me.kupchenko.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
}
