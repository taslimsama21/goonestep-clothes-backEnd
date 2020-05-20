package com.goonestep.goonestepClothesAppBackEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goonestep.goonestepClothesAppBackEnd.models.User;
import com.goonestep.goonestepClothesAppBackEnd.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/user/list")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
}
