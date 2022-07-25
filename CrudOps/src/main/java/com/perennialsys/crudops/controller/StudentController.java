package com.perennialsys.crudops.controller;

import com.perennialsys.crudops.exception.ResourceNotFoundException;
import com.perennialsys.crudops.model.Student;
import com.perennialsys.crudops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /*
    Build create student REST API
    @Request Body internally converts JSON into Java object
     */
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    /*
    Build get student by id REST API
     */
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentId(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exist with id : " + id));
        return ResponseEntity.ok(student);
    }

    /*
    Update student REST API
    PutMapping is used for updating a resource
     */
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentDetails) {
        Student updateStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id : " + id));

        updateStudent.setFirstName(studentDetails.getFirstName());
        updateStudent.setLastName(studentDetails.getLastName());
        updateStudent.setEmailId(studentDetails.getEmailId());

        studentRepository.save(updateStudent);
        return ResponseEntity.ok(updateStudent);
    }

    /*
    build delete employee REST API
     */

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not exists with id : " + id));
        studentRepository.delete(student);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}












