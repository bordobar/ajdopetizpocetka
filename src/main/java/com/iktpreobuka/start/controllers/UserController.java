package com.iktpreobuka.start.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iktpreobuka.start.entities.UserEntity;
import com.iktpreobuka.start.repositories.UserRepository;

@RestController
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.POST)
	public UserEntity addNewUser(@RequestBody UserEntity newUser) {
		UserEntity user = new UserEntity();
		userRepository.save(user);
		return user;
	}
	
	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET, path = "/all")
	public Iterable<UserEntity> getAllUsers(){
		return userRepository.findAll();
	}
}
