package com.School.Student.studentdata.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String name;

    private String email;


}
