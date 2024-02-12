package com.example.ProjectPracticeAngular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectPracticeAngular.dao.UserDao;
import com.example.ProjectPracticeAngular.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao ud;
	
	public boolean addUser(User user) {
		return ud.addUser(user);
	}

	public User getUser(User user) {
	    return ud.getUser(user);
	}

}
