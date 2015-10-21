package com.pettypal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettypal.domain.Notification;
import com.pettypal.domain.NotificationType;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

	@Query("SELECT n FROM notification n WHERE n.type = :type")
	List<Notification> findNotificationsByType(@Param("type") NotificationType type);

	@Query("SELECT n FROM notification n WHERE n.reciever.id = :id")
	List<Notification> findNotificationsByUser(@Param("id") Long id);

}
