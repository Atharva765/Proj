package com.HospitalApp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.HospitalApp.api.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
	
	@Query("select p from Prescription p where p.username=?1")
	Prescription findByUsername(String username);
	
}
