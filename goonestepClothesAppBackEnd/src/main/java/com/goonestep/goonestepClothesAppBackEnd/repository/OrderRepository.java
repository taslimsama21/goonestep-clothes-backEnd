package com.goonestep.goonestepClothesAppBackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goonestep.goonestepClothesAppBackEnd.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{

	//User
	
	@Query("SELECT o FROM Order o WHERE o.userId=:orderId")
	public List<Order> getMyAllOrders(@Param("orderId") Long orderId);
	
	@Query("SELECT o FROM Order o WHERE o.canceledOrder = 1")
	public List<Order> findCanceledOrders(@Param("orderId") Long orderId);

	@Query("SELECT o FROM Order o WHERE o.approvedOrder = 1 AND o.userId=:orderId")
	public List<Order> findApprovedOrders(@Param("orderId") Long orderId);

	@Query("SELECT o FROM Order o WHERE o.rejectedOrder = 1 AND o.userId=:orderId")
	public List<Order> findRejectedOrders(@Param("orderId") Long orderId);

	
	//Admin

	
	@Query("SELECT o FROM Order o WHERE o.approvedOrder = 1")
	public List<Order> getAllApprovedOrders();

	@Query("SELECT o FROM Order o WHERE o.rejectedOrder = 1")
	public List<Order> getAllRejectedOrders();

	@Query("SELECT count(o) FROM Order o WHERE o.userId=:orderId")
	public int findOrderByOrderId(@Param("orderId") Long orderId);

	
	
}
