package com.goonestep.goonestepClothesAppBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goonestep.goonestepClothesAppBackEnd.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

	Order findByOrderId(int orderId);

	List<Order> findAll();
	
	
}
