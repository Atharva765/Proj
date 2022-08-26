package com.HospitalApp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalApp.api.model.Prescription;
import com.HospitalApp.api.repository.PrescriptionRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class PrescriptionController {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@PostMapping("/prescription/{username}")
	public Prescription postPrescription(@PathVariable("username")String username,
					@RequestBody Prescription prescription) {
		
		prescription.setUsername(username);
		return prescriptionRepository.save(prescription);
	}
	
	@GetMapping("/getprescription/{username}")
	public Prescription getPrescription(@PathVariable("username")String username) {
		
		Prescription prescription = prescriptionRepository.findByUsername(username);
		return prescription;
	}
}
