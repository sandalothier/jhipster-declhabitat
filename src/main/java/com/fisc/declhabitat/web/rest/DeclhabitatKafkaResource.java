package com.fisc.declhabitat.web.rest;

import com.fisc.declhabitat.service.DeclhabitatKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declhabitat-kafka")
public class DeclhabitatKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclhabitatKafkaResource.class);

    private DeclhabitatKafkaProducer kafkaProducer;

    public DeclhabitatKafkaResource(DeclhabitatKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
