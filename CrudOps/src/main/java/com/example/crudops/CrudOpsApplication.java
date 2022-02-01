package com.example.crudops;

import com.example.crudops.model.Student;
import com.example.crudops.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudOpsApplication implements CommandLineRunner{//

    public static void main(String[] args) {
        SpringApplication.run(CrudOpsApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student=new Student();
        student.setFirstName("Sona");
        student.setLastName("Sinha");
        student.setEmailId("sona@gmail.com");

        studentRepository.save(student);
    }
}
