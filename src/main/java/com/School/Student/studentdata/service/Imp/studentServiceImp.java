package com.School.Student.studentdata.service.Imp;
import com.School.Student.studentdata.dto.AddStudentRequestDto;
import com.School.Student.studentdata.dto.StudentDto;
import com.School.Student.studentdata.entity.Student;
import com.School.Student.studentdata.exception.ResourceNotFoundException;
import com.School.Student.studentdata.repository.StudentRepository;
import com.School.Student.studentdata.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class studentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    public studentServiceImp(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }
    public StudentDto createStudent(AddStudentRequestDto addStudentRequestDto){
        /*Student student =new Student();
        student.setName(addStudentRequestDto.getName());
        student.setEmail(addStudentRequestDto.getEmail());
        Student savedStudent=studentRepository.save(student);
        StudentDto dto=new StudentDto();
        dto.setId(savedStudent.getId());
        dto.setName(savedStudent.getName());
        dto.setEmail(savedStudent.getEmail());
        return dto;*/

        Student newstudent=modelMapper.map(addStudentRequestDto,Student.class);
        Student student=studentRepository.save(newstudent);
        return modelMapper.map(student,StudentDto.class);

    }


    public List<StudentDto> getAllStudents(){
        List<Student> student=studentRepository.findAll();
        return student.stream().map(students -> {
            StudentDto dto=new StudentDto();
            dto.setId(students.getId());
            dto.setName(students.getName());
            dto.setEmail(students.getEmail());
            return dto;
        }).collect(Collectors.toList());

       /* return student
                .stream()
                .map(students -> modelMapper.map(students,StudentDto.class))
                .toList();*/
    }

    public StudentDto getStudentById(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("student not found"));
        return   modelMapper.map(student,StudentDto.class);
    }
    public StudentDto updateStudents(Long id,StudentDto studentDto){
        Student student=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student not found"));
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());

        Student updateStudent=studentRepository.save(student);

        StudentDto dto=new StudentDto();
        dto.setId(updateStudent.getId());
        dto.setName(updateStudent.getName());
        dto.setEmail(updateStudent.getEmail());
        return dto;
    }

    public void removeStudent(Long id){
        Student student=studentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("student not found"));
        studentRepository.deleteById(id);
    }



}
