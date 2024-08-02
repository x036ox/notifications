package com.artur.listener;

import com.artur.common.exception.NotFoundException;
import com.artur.eventhandler.VideoCreatedNotificationEventHandler;
import com.artur.facade.NotificationFacade;
import com.artur.service.NotificationService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class VideoCreateListener {

    @Autowired
    VideoCreatedNotificationEventHandler videoCreatedNotificationEventHandler;

    @KafkaListener(
            containerFactory = "containerFactory",
            groupId = "video-create:consumer",
            topics = "video-created.notification"
    )
    public void videoCreateConsume(ConsumerRecord<String, String> consumerRecord){
        try {
            System.out.println("LISTENED");
            videoCreatedNotificationEventHandler.handleNotificationEvent(Long.parseLong(consumerRecord.value()));
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
