package com.artur.service;

public class EmailNotificationService implements NotificationService{

    @Override
    public void sendNotification(String to, String message) {
        //TODO: implement email notifications
        System.out.println("Sending notification, to:  " + to + ", message: " + message);
//        throw new UnsupportedOperationException("Email notification is not supported yet.");
    }
}
