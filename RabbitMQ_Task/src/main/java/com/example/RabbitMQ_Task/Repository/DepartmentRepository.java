package com.example.RabbitMQ_Task.Repository;

import com.example.RabbitMQ_Task.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
