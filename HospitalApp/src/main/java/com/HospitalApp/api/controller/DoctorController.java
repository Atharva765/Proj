package com.HospitalApp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalApp.api.model.Doctors;
import com.HospitalApp.api.repository.DoctorRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@PostMapping("/doctor")
	public Doctors postDoctor(@RequestBody Doctors doctor) {
		return doctorRepository.save(doctor);
	}
	
	@GetMapping("/doctor")
	public List<Doctors> getAllDoctor() {
		return doctorRepository.findAll();
	}
	
	
}
