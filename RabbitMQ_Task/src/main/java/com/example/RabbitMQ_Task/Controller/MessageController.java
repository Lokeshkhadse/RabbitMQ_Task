    package com.example.RabbitMQ_Task.Controller;

    import com.example.RabbitMQ_Task.Service.MessageProducer;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/send")
    public class MessageController {

        @Autowired
        private MessageProducer messageProducer;

        @PostMapping
        public ResponseEntity<String>sendMessage(@RequestBody String jsonmsg){
            messageProducer.sendmsg(jsonmsg);
            return new ResponseEntity<>("msg sent", HttpStatus.OK);
        }

        // Convert the DTO to JSON string
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonMessage = objectMapper.writeValueAsString(messageDTO);
//
//        // Send the JSON message to RabbitMQ
//        messageProducer.sendmsg(jsonMessage);
//
//        return new ResponseEntity<>("Message sent", HttpStatus.OK);
    }
