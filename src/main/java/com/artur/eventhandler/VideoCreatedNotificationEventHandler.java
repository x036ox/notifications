package com.artur.eventhandler;

import com.artur.common.entity.VideoEntity;
import com.artur.common.exception.NotFoundException;
import com.artur.common.repository.VideoRepository;
import com.artur.facade.NotificationFacade;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VideoCreatedNotificationEventHandler {
    @Autowired
    VideoRepository videoRepository;
    @Autowired
    NotificationFacade notificationFacade;

    @Transactional
    public void handleNotificationEvent(Long videoId) throws NotFoundException {
        VideoEntity videoEntity = videoRepository.findById(videoId).orElseThrow(() -> new NotFoundException("Video, received from Kafka, was not found"));
        videoEntity.getUser().getSubscribers().forEach(user ->
                notificationFacade.notify(user, user.getUsername() + " created new video!"));
    }
}
