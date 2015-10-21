package com.pettypal.service;

import java.util.List;

import com.pettypal.domain.Notification;
import com.pettypal.domain.NotificationType;

public interface NotificationService {
	
	public Notification save(Notification notification);
	
	public Notification getNotificationById(long notificationId);
	
	public List<Notification> getNotificationListByType(NotificationType type);
	
	public List<Notification> getNotificationListByUser(Long id);
 
}
