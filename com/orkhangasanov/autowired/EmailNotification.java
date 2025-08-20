package com.orkhangasanov.autowired;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending EMAIL (prod): " + message);
    }
}
