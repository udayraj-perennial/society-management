package com.perennialsys.crudops.repository;

import com.perennialsys.crudops.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
