package com.goonestep.goonestepClothesAppBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goonestep.goonestepClothesAppBackEnd.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
