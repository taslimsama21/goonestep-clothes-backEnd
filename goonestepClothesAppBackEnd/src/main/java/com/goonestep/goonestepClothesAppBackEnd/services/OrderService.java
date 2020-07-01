package com.goonestep.goonestepClothesAppBackEnd.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goonestep.goonestepClothesAppBackEnd.models.Order;
import com.goonestep.goonestepClothesAppBackEnd.models.User;
import com.goonestep.goonestepClothesAppBackEnd.repository.OrderRepository;
import com.goonestep.goonestepClothesAppBackEnd.response.MessageResponse;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepositoryForService;

	public ResponseEntity<?> addNewOrder(Long orderId, Order orderData) {
		orderData.setOrderId(orderId);
		orderData.setName(orderData.getName());
		orderData.setEmail(orderData.getEmail());
		orderData.setAddress(orderData.getAddress());
		orderData.setPincode(orderData.getPincode());
		orderData.setPhoneNumber(orderData.getPhoneNumber());
		orderData.setProductId(orderData.getProductId());
		orderData.setQuantity(orderData.getQuantity());
		orderData.setApprovedOrder(false);
		orderData.setRejectedOrder(false);
		orderData.setCanceledOrder(false);
		orderData.setOrderStatus(false);
		orderData.setTotalCost(orderData.getTotalCost());
		orderData.setUserId(orderData.getUserId());
		orderRepositoryForService.save(orderData);
		
		return ResponseEntity.ok(new MessageResponse("Your Order has been placed succesfully!!"));
	}

	public ResponseEntity<?> editOrder(Long orderId, Order orderData) {
		
		Optional<Order> data = orderRepositoryForService.findById(orderId);
		Order order = data.get();
		order.setEmail(orderData.getEmail());
		order.setAddress(orderData.getAddress());
		order.setPhoneNumber(orderData.getPhoneNumber());
		order.setPincode(orderData.getPincode());
		order.setQuantity(orderData.getQuantity());

		return ResponseEntity.ok(new MessageResponse("Your Order Edited Successfully!!"));
	}

	public ResponseEntity<?> cancelOrder(Long orderId, Order orderData) {
		Optional<Order> data = orderRepositoryForService.findById(orderId);
		Order order = data.get();
		order.setCanceledOrder(true);
		order.setOrderStatus(false);
		return new ResponseEntity<>(orderRepositoryForService.save(order),HttpStatus.OK);
	}

	public List<Order> getMyAllOrders(Long orderId) {
		List<Order> orders  = orderRepositoryForService.getMyAllOrders(orderId);
		return orders;
	}
	
	public List<Order> getMyCanceledOrders(Long orderId) {
		List<Order> orders  = orderRepositoryForService.findCanceledOrders(orderId);
		return orders;
	}

	public List<Order> getMyApprovedOrders(Long orderId) {
		List<Order> orders  = orderRepositoryForService.findApprovedOrders(orderId);
		return orders;
	}

	public List<Order> getMyRejectedOrders(Long orderId) {
		List<Order> orders  = orderRepositoryForService.findRejectedOrders(orderId);
		return orders;
	}

	public Order getOrderDetails(Long orderId) {
		Optional<Order> data = orderRepositoryForService.findById(orderId);
		Order orderInfo = data.get();
		return orderInfo;
	}
	
	//Admin....

		public List<Order> listOutApprovedOrders() {
			List<Order> allOrders = orderRepositoryForService.getAllApprovedOrders();
			return allOrders;	
		}

		public ResponseEntity<?> rejectOrder(Order orderData) {
			Optional<Order> data = orderRepositoryForService.findById(orderData.getOrderId());
			Order order = data.get();
			order.setRejectedOrder(true);
			order.setOrderStatus(true);
			return new ResponseEntity<>(orderRepositoryForService.save(order),HttpStatus.OK);
		}

		public ResponseEntity<?> approveOrder(Order orderData) {
			Optional<Order> data = orderRepositoryForService.findById(orderData.getOrderId());
			Order order = data.get();
			order.setApprovedOrder(true);
			order.setOrderStatus(true);
			return new ResponseEntity<>(orderRepositoryForService.save(order),HttpStatus.OK);
		}

		public List<Order> listOutRejectedOrders() {
			List<Order> allOrders = orderRepositoryForService.getAllRejectedOrders();
			return allOrders;
		}

		public List<Integer> listOrdersofUser(List<User> userData) {
			List<Integer> orders = new ArrayList<Integer>();
			
			for(int i=0;i<userData.size();i++) {
				int order = orderRepositoryForService.findOrderByOrderId(userData.get(i).getId());
				orders.add(order);
			}
			return orders;
		}
	

}
