package com.orkhangasanov.autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
