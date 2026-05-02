package com.School.Student.studentdata.controller;

import com.School.Student.studentdata.dto.AddStudentRequestDto;
import com.School.Student.studentdata.dto.StudentDto;
import com.School.Student.studentdata.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@Controller
@RestController
@RequestMapping("/api/students")
public class StudentContoller {
    private final StudentService studentService;
    public StudentContoller(StudentService studentService) {
        this.studentService = studentService;
    }

  @PostMapping
  public ResponseEntity<StudentDto> createStudents(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentRequestDto));
  }
  @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
  }
  @GetMapping("/{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
  }

  @PutMapping("/{id}")
  public StudentDto updateStudent(@PathVariable Long id,@RequestBody StudentDto studentDto ){
        return studentService.updateStudents(id,studentDto);
  }
  @DeleteMapping("/{id}")
  public String removeStudent(@PathVariable Long id){
        studentService.removeStudent(id);
        return "student deleted successfully";
  }
}
