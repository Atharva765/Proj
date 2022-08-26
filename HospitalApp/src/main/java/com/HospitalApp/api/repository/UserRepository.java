package com.HospitalApp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalApp.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
