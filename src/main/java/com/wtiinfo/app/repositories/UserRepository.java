package com.wtiinfo.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wtiinfo.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
