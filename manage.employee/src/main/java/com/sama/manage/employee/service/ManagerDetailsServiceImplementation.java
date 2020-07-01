package com.sama.manage.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sama.manage.employee.models.Manager;
import com.sama.manage.employee.repository.ManagerRepository;

@Service
public class ManagerDetailsServiceImplementation implements UserDetailsService {

	@Autowired
	ManagerRepository managerrRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Manager manager = managerrRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));

		return ManagerDetailsImplementation.build(manager);
	}

}
