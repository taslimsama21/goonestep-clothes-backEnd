package com.goonestep.goonestepClothesAppBackEnd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goonestep.goonestepClothesAppBackEnd.models.Order;
import com.goonestep.goonestepClothesAppBackEnd.models.User;
import com.goonestep.goonestepClothesAppBackEnd.repository.OrderRepository;
import com.goonestep.goonestepClothesAppBackEnd.services.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.goonestep.goonestepClothesAppBackEnd.repository"},
repositoryBaseClass = OrderRepository.class)
@RequestMapping("api")
public class OrderController {

	@Autowired
	OrderRepository orderRepositoryForOrderController;

	@Autowired 
	OrderService orderService;
	
	//user
	
	@GetMapping("/user/order/list")
	@PreAuthorize("hasRole('USER')")
	public List<Order> getMyAllOrders(@PathVariable("orderId") Long orderId) {
		return orderRepositoryForOrderController.getMyAllOrders(orderId);
	}
	
	@PreAuthorize("hasRole('USER')")
    @PostMapping("/user/order/new")
	public ResponseEntity<?>addNewOrder(@PathVariable("orderId") Long orderId,@RequestBody Order orderData){
		return orderService.addNewOrder(orderId,orderData);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/user/order/edit")
     public ResponseEntity<?> editOrder(@PathVariable("orderId") Long orderId, @RequestBody Order orderData){
	return orderService.editOrder(orderId,orderData);	
	}
	
	@PreAuthorize("hasRole('USER')")
	@PutMapping("/user/order/cancel")
	public ResponseEntity<?> cancelOrder(@PathVariable("orderId") Long orderId,@RequestBody Order orderData){
		return orderService.cancelOrder(orderId,orderData);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/order/canceled")
	public List<Order> getMyCanceledOrders(@PathVariable("orderId") Long orderId){
		return orderService.getMyCanceledOrders(orderId);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/order/approved")
	public List<Order> getMyApprovedOrders(@PathVariable("orderId") Long orderId){
		return orderService.getMyApprovedOrders(orderId);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/order/rejected")
	public List<Order> getMyRejectedOrders(@PathVariable("orderId") Long orderId){
		return orderService.getMyRejectedOrders(orderId);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/user/order/details")
	public Order getOrderDetails(@PathVariable("orderId") Long orderId) {
		return orderService.getOrderDetails(orderId);
	}
	
	//admin
		
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/admin/order/approve")
	public ResponseEntity<?> approveOrder(@RequestBody Order orderData){
		return orderService.approveOrder(orderData);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/admin/order/reject")
	public ResponseEntity<?> rejectOrder(@RequestBody Order orderData){
		return orderService.rejectOrder(orderData);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin/order/total")
	public List<Order> getTotalOrders() {
		return orderRepositoryForOrderController.findAll();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin/order/approved")
	public List<Order> listOutApprovedOrders(){
		return orderService.listOutApprovedOrders();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin/order/rejected")
	public List<Order> listOutRejectedOrders(){
		return orderService.listOutRejectedOrders();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin/order/of/user")
	public List<Integer> listOrdersofUser(@RequestBody List<User> userData){
		return orderService.listOrdersofUser(userData);
	}
	
	
}
