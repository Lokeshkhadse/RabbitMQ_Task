package com.example.RabbitMQ_Task.Repository;

import com.example.RabbitMQ_Task.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

}
