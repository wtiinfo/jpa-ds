package com.wtiinfo.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(path = "/paged")
	public ResponseEntity<Page<User>> findAll(Pageable pageable){
		return ResponseEntity.ok(userRepository.findAll(pageable));	
	}
	
	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<User>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
	    return ResponseEntity.ok(userRepository.searchBySalary(minSalary, maxSalary, pageable));
	}
	
	@GetMapping(value = "/search-salary-queryMethod")
	public ResponseEntity<Page<User>> searchBySalaryQueryMethod(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
	    return ResponseEntity.ok(userRepository.findBySalaryBetween(minSalary, maxSalary, pageable));
	}
	
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<User>> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable) {
	    return ResponseEntity.ok(userRepository.searchByName(name, pageable));
	}
	
	@GetMapping(value = "/search-name-queryMethod")
	public ResponseEntity<Page<User>> searchByNameQueryMethod(@RequestParam(defaultValue = "") String name, Pageable pageable) {
	    return ResponseEntity.ok(userRepository.findByNameContainingIgnoreCase(name, pageable));
	}
	
}
