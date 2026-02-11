package com.dev.register.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.register.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmailid(String emailId);
	
	boolean existsByEmailid(String emailId);

}
