package com.artur.service.factory;

import com.artur.service.PhoneNumberNotificationService;
import com.artur.service.EmailNotificationService;
import com.artur.service.NotificationService;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceFactory {

    public NotificationService emailNotificationService(){
        return new EmailNotificationService();
    }

    public NotificationService phoneNumberNotificationService(){
        return new PhoneNumberNotificationService();
    }
}
