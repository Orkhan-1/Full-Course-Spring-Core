package com.orkhangasanov.autowired;

import org.springframework.stereotype.Service;

@Service
public class SMSNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}