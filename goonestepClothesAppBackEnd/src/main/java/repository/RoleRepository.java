package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import models.ERole;
import models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(ERole name);
	
}
