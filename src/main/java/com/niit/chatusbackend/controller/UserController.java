package com.niit.chatusbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chatusbackend.dao.UserDAO;
import com.niit.chatusbackend.model.User;

@RestController
public class UserController {

	@Autowired
	UserDAO userDAO;
	 @PostMapping(value="/register")
			 
	 public ResponseEntity<User> createUser(@RequestBody User user) 
	 {
		 userDAO.saveOrUpdate(user);
		 return new ResponseEntity<User>(user,HttpStatus.OK);
	 }
	 
	 @GetMapping(value="/users/")
	 public ResponseEntity<List<User>>listUser()
	 {
		 List<User> users=userDAO.list();
		 return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		 
	 }
	 @RequestMapping(value="/Hello")
	 
		 public String sayHello()
		 {
			 return "Hello";
	 }
	 }

