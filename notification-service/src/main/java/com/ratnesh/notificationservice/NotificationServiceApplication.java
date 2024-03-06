package com.ratnesh.notificationservice;

import com.ratnesh.notificationservice.event.LoanNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @KafkaListener(topics = "loan-notification")
    public void handleNotification(LoanNotification event) {
        log.info("Notification received: {}", event);

    }

}
