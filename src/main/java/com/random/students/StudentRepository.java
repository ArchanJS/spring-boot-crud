package com.random.students;

import org.springframework.data.repository.CrudRepository;
import com.random.students.Student;

public interface StudentRepository extends CrudRepository<Student,Integer> {
    
}
