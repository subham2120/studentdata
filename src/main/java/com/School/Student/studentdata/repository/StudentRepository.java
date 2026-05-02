package com.School.Student.studentdata.repository;

import com.School.Student.studentdata.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
