package com.example.clients.notification.client;

import com.example.clients.notification.request.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}
