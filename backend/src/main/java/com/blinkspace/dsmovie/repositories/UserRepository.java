package com.blinkspace.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkspace.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
