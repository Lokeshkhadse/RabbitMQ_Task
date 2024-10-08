package com.example.RabbitMQ_Task.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class CommonTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long sno;
    private String message;
    private boolean isRead;
}
