package com.example.RabbitMQ_Task.Repository;

import com.example.RabbitMQ_Task.Entity.CommonTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommonTableRepository extends JpaRepository<CommonTable,Long> {
    List<CommonTable> findByIsRead(boolean isRead);
}
