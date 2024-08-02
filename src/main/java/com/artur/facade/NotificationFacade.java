package com.artur.facade;

import com.artur.common.entity.user.UserEntity;
import com.artur.service.factory.NotificationServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationFacade {

    @Autowired
    NotificationServiceFactory notificationServiceFactory;

    public void notify(UserEntity user, String message){
        notificationServiceFactory.emailNotificationService().sendNotification(user.getEmail(), message);
        //if user enabled notifications by phone
//        notificationServiceFactory.phoneNumberNotificationService().sendNotification("some phone", message);
        //and so on
    }
}
