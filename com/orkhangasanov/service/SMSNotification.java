package com.orkhangasanov.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending SMS (dev): " + message);
    }
}