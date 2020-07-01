package com.sama.manage.employee.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sama.manage.employee.jwt.JwtUtils;
import com.sama.manage.employee.models.EnumRole;
import com.sama.manage.employee.models.Manager;
import com.sama.manage.employee.models.Role;
import com.sama.manage.employee.repository.ManagerRepository;
import com.sama.manage.employee.repository.RoleRepository;
import com.sama.manage.employee.request.LoginRequest;
import com.sama.manage.employee.request.SignUpRequest;
import com.sama.manage.employee.response.JwtResponse;
import com.sama.manage.employee.response.MessageResponse;
import com.sama.manage.employee.service.ManagerDetailsImplementation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		ManagerDetailsImplementation managerDetails = (ManagerDetailsImplementation) authentication.getPrincipal();
		List<String> roles = managerDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, managerDetails.getId(), managerDetails.getEmail(), roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		if (managerRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new manager's account
		Manager manager = new Manager(signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getFirstname(), signUpRequest.getLastname(), signUpRequest.getAddress(),
				signUpRequest.getCompany(), signUpRequest.getDateofBirth());

		Set<Role> roles = new HashSet<>();

		Role managerRole = roleRepository.findByName(EnumRole.ROLE_MANAGER)
				.orElseThrow(() -> new RuntimeException("Error:  No Role is not found."));
		roles.add(managerRole);

		manager.setRoles(roles);
		managerRepository.save(manager);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}
}
