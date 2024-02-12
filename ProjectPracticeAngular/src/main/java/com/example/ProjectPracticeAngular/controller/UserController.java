package com.example.ProjectPracticeAngular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectPracticeAngular.entity.User;
import com.example.ProjectPracticeAngular.service.UserService;

@CrossOrigin
@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/addingUser")
	public boolean addUser(@RequestBody User user) {
		return us.addUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity getUser(@RequestBody User user) {
		User uu =  us.getUser(user);
		if(uu == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		} else {
			return ResponseEntity.ok().body(uu);
		}
	}
}
