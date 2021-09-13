package com.wtiinfo.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wtiinfo.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.salary >= :minSalary AND u.salary <= :maxSalary")
	Page<User> searchBySalary(Double minSalary, Double maxSalary, Pageable pageable);
	
	//Opção ao método acima usando Query Method Spring Data JPA
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);
	
	@Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	Page<User> searchByName(String name, Pageable pageable);
	
	//Opção ao método acima usando Query Method Spring Data JPA
	Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
