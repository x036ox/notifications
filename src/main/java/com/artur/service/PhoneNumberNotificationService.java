package com.artur.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneNumberNotificationService implements NotificationService{
    @Override
    public void sendNotification(String to, String message) {
        System.out.println("Received notification, to:  " + to + ", message: " + message);
    }
}
