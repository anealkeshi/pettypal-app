package com.pettypal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pettypal.domain.Notification;
import com.pettypal.domain.NotificationType;
import com.pettypal.repository.NotificationRepository;
import com.pettypal.service.NotificationService;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {
	
	private NotificationRepository notificationRepository;

	public Notification save(Notification notification) {
		
		return notificationRepository.save(notification);
	}

	public Notification getNotificationById(long notificationId) {
		
		return notificationRepository.findOne(notificationId);
	}

	public List<Notification> getNotificationListByType(NotificationType type) {
		
		return (List<Notification>) notificationRepository.findNotificationsByType(type);
	}

}
