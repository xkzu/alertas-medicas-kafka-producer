package com.alertasmedicas.app.kafka_producer.controller;

import com.alertasmedicas.app.kafka_producer.service.KafkaProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/kafka")
public class ProducerController {

    private final KafkaProducerService producerService;

    @Autowired
    public ProducerController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        producerService.sendMessage(message);
        log.info("Mensaje enviado: {}", message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
