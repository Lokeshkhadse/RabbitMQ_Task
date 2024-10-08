package com.example.RabbitMQ_Task.Service;

import com.example.RabbitMQ_Task.Config.RabbitMQConfig;
import com.example.RabbitMQ_Task.Entity.CommonTable;
import com.example.RabbitMQ_Task.Entity.Department;
import com.example.RabbitMQ_Task.Entity.Student;
import com.example.RabbitMQ_Task.Repository.CommonTableRepository;
import com.example.RabbitMQ_Task.Repository.DepartmentRepository;
import com.example.RabbitMQ_Task.Repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;

import java.nio.charset.StandardCharsets;

@Service
public class MessageListener {

    @Autowired
    private CommonTableRepository commonTableRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @RabbitListener(queues = RabbitMQConfig.Queue_Name)
    public void consume(byte[] msgbytes) throws JsonProcessingException {
        String msg = new String(msgbytes);

       // JSONPObject jsonObject = new JSONPObject(IOUtils.toString(msgbytes, StandardCharsets.UTF_8));

        CommonTable commonTable = new CommonTable();
        commonTable.setMessage(msg);
        commonTable.setRead(true);
        commonTableRepository.save(commonTable);

//        JSONObject json = new JSONObject(msg);
//        if (json.has("student")) {
//            // Assuming the student object is a JSONObject
//            Student student = new ObjectMapper().readValue(json.getJSONObject("student").toString(), Student.class);
//            studentRepository.save(student);
//        }
//        if (json.has("department")) {
//            Department department = new ObjectMapper().readValue(json.getJSONObject("department").toString(), Department.class);
//            departmentRepository.save(department);
//        }

        //if i used DTO
        // Convert the JSON message to MessageDTO
//        ObjectMapper objectMapper = new ObjectMapper();
//        MessageDTO messageDTO = objectMapper.readValue(jsonMessage, MessageDTO.class);
//
//        // Save Student if present
//        if (messageDTO.getStudent() != null) {
//            studentRepository.save(messageDTO.getStudent());
//        }
//
//        // Save Department if present
//        if (messageDTO.getDepartment() != null) {
//            departmentRepository.save(messageDTO.getDepartment());
//        }



    }

}
