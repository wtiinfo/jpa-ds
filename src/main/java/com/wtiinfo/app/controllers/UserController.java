package com.wtiinfo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wtiinfo.app.entities.User;
import com.wtiinfo.app.repositories.UserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(userRepository.findAll());	
	}
}
