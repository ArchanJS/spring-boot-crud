package com.random.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addStudent(@RequestParam String name, @RequestParam String department, @RequestParam int year){
        Student st=new Student();
        st.setName(name);
        st.setDepartment(department);
        st.setYear(year);
        studentRepository.save(st);
        return "User has been added to the database";
    }

    @GetMapping(path="/")
    public @ResponseBody Iterable<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody Student getStudentsOfSameYear(@PathVariable("id") int id){
        return studentRepository.findById(id).get();
    }

}
