package me.kupchenko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
}
