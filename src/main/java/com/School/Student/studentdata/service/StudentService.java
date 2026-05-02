package com.School.Student.studentdata.service;

import com.School.Student.studentdata.dto.AddStudentRequestDto;
import com.School.Student.studentdata.dto.StudentDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {
     StudentDto createStudent(AddStudentRequestDto addStudentRequestDto);

     List<StudentDto> getAllStudents();
     StudentDto updateStudents(Long id,StudentDto studentDto);
     void removeStudent(Long id);
     StudentDto getStudentById(Long id);

}
