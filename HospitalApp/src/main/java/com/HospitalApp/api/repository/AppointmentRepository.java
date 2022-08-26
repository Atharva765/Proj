package com.HospitalApp.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HospitalApp.api.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	List<Appointment> findByDoctorsId(Long did);

}
