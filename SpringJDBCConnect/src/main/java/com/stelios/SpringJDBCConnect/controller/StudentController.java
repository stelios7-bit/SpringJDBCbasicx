package com.stelios.SpringJDBCConnect.controller;

import com.stelios.SpringJDBCConnect.model.Student;
import com.stelios.SpringJDBCConnect.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepo repo;

    // CREATE
    @PostMapping
    public Student createStudent(@Valid @RequestBody Student student) {
        return repo.save(student);
    }

    // READ ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return repo.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
        return "Student with ID " + id + " deleted successfully.";
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @Valid @RequestBody Student updatedStudent) {
        return repo.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setCourse(updatedStudent.getCourse());
            return repo.save(student);
        }).orElseGet(() -> {
            updatedStudent.setId(id);
            return repo.save(updatedStudent);
        });
    }
}
