package com.goonestep.goonestepClothesAppBackEnd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goonestep.goonestepClothesAppBackEnd.models.ERole;
import com.goonestep.goonestepClothesAppBackEnd.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
	
}
