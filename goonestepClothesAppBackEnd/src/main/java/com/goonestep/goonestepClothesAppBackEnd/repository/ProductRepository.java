package com.goonestep.goonestepClothesAppBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goonestep.goonestepClothesAppBackEnd.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
