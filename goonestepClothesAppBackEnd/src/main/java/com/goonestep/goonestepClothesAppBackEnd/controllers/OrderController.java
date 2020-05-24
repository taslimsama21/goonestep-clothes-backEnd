package com.goonestep.goonestepClothesAppBackEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goonestep.goonestepClothesAppBackEnd.models.Order;
import com.goonestep.goonestepClothesAppBackEnd.repository.OrderRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;

	
	//user
	
	@GetMapping("/user/order/list")
	@PreAuthorize("hasRole('USER')")
	public List<Order> getMyAllOrders() {
		return orderRepository.findAll();
	}

	
	
}
