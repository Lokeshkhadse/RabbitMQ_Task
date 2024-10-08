package com.example.RabbitMQ_Task.Service;

import com.example.RabbitMQ_Task.Entity.CommonTable;
import com.example.RabbitMQ_Task.Entity.Department;
import com.example.RabbitMQ_Task.Entity.Student;
import com.example.RabbitMQ_Task.Repository.CommonTableRepository;
import com.example.RabbitMQ_Task.Repository.DepartmentRepository;
import com.example.RabbitMQ_Task.Repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageSchedular {
    @Autowired
    private CommonTableRepository commonTableRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Scheduled(fixedRate = 120000) // 120000 milliseconds = 2 minutes
    public void processMessages() {
        // Fetch messages where isRead is true
        List<CommonTable> messages = commonTableRepository.findByIsRead(true);

        for (CommonTable commonMessage : messages) {
            try {
                // Deserialize JSON
                String message = commonMessage.getMessage();
                JSONObject json = new JSONObject(message);//convert string json obj into json obj
                ObjectMapper objectMapper = new ObjectMapper();//it is Jackson  library it is used to convert json object into actual java obj

                // Process student if exists
                if (json.has("student")) {
                    Student student = objectMapper.readValue(json.getJSONObject("student").toString(), Student.class);
                    studentRepository.save(student);
                }

                // Process department if exists
                if (json.has("department")) {
                    Department department = objectMapper.readValue(json.getJSONObject("department").toString(), Department.class);
                    departmentRepository.save(department);
                }

                // Set isRead to false after processing
                commonMessage.setRead(false);
                commonTableRepository.save(commonMessage);

            } catch (Exception e) {
                e.printStackTrace(); // Handle exception as needed
            }
        }
    }
}
