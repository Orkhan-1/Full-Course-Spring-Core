package com.orkhangasanov.autowired;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}