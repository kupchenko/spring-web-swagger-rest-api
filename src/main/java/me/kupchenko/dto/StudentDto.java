package me.kupchenko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
}
