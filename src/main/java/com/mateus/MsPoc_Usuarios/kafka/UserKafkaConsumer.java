package com.mateus.MsPoc_Usuarios.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mateus.MsPoc_Usuarios.Repository.UserRepository;
import com.mateus.shared.UserRequest;
import com.mateus.shared.UserResponse;

@Component
public class UserKafkaConsumer {

    @Autowired
    private UserRepository repository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(
        topics = "user-request",
        groupId = "users-ms"
    )
    public void listen(UserRequest request) throws Exception {

        System.out.println("Received message: " + request.email());

        var user = repository.findByEmail(request.email());
        
        var response = user!=null? new UserResponse(
            user.getEmail(),
            user.getPassword(),
            request.correlationId()
        ): new UserResponse(
            null,
            null,
            request.correlationId()
        );

        String json = objectMapper.writeValueAsString(response);

        kafkaTemplate.send("user-response", json);
    }
}