package com.seartchina.mika.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seartchina.mika.dao.user.UserDao;
import com.seartchina.mika.dao.user.UserNotificationDao;
import com.seartchina.mika.dao.user.pojo.User;
import com.seartchina.mika.dao.user.pojo.UserNotification;
import com.seartchina.mika.service.constants.QuestNotification;

@Service
public class NotificationUtils {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserNotificationDao userNotificationDao;
	
	public void sendNotification(Integer userId, String message, Integer notificationType){
		UserNotification userNotification = new UserNotification();
		userNotification.setMessage(message);
		userNotification.setUserId(userId);
		userNotification.setNotificationType(notificationType);
		userNotificationDao.addNotification(userNotification);
	}
	
	// TODO: return human phrase
	public String questInitOwner(Integer userId) {
		User user = userDao.selectUser(userId);
		String userName = user.getUserName();
		return userName;
	}
	
	// TODO: return human phrase
	public String questInitParticipant(Integer friendId) {
		User user = userDao.selectUser(friendId);
		String userName = user.getUserName();
		return userName;
	}
	
	// TODO: return human phrase
	public String questSuccess(Integer userId, Integer elementId, Integer quantity) {
		User user = userDao.selectUser(userId);
		String userName = user.getUserName();
		return userName + elementId + quantity;
	}
	
	// TODO: return human phrase
	public String questFailure(Integer userId) {
		User user = userDao.selectUser(userId);
		String userName = user.getUserName();
		return userName;
	}

}
