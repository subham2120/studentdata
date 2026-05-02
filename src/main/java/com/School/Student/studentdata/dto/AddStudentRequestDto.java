package com.School.Student.studentdata.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddStudentRequestDto {

    @NotBlank
    @Size(min = 3,max = 30,message="Name should be of length 3 to 30 character")
    private String name;
    @Email
    @NotBlank
    private String email;


}
