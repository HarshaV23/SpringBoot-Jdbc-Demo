package com.waleed.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	UserDao dao;

	Integer getCountOfUsers() {
		return dao.getCountOfUsers();
	}
	
	String getUserName(String name) {
		return dao.getUserName(name);
	}
	
	int createUser(User user) {
		return dao.createUser(user);
	}
	
	User getUser(String userId) {
		return dao.getUser(userId);
	}
	int updateUser(String userId,User user) {
		return dao.updateUser(userId,user);
	}
	int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}
	List<User> listOfUsers(){
		return dao.listOfUsers();
	}
}
