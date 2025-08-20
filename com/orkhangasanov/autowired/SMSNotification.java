package com.orkhangasanov.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending SMS (dev): " + message);
    }
}