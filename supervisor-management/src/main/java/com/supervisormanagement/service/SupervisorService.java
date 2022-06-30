package com.supervisormanagement.service;

import com.supervisormanagement.dto.NotificationRequestDTO;

public interface SupervisorService {
    Object getAllSupervisors();

    Object createNotification(NotificationRequestDTO notificationRequestDTO);
}
