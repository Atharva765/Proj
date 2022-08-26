package com.HospitalApp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalApp.api.model.Doctors;

public interface DoctorRepository extends JpaRepository<Doctors, Long>{

	

}
