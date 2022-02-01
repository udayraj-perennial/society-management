package com.example.crudops.repository;

import com.example.crudops.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student , Long> {
    //All crud database methods
}
