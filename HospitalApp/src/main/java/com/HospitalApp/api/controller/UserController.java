package com.HospitalApp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.HospitalApp.api.model.Doctors;
import com.HospitalApp.api.model.User;
import com.HospitalApp.api.repository.DoctorRepository;
import com.HospitalApp.api.repository.UserRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DoctorRepository doctorRepository; 
	
	@PostMapping("/user/{did}")
	public User postDoctorUser(@PathVariable("did")Long did, @RequestBody User user) {
		Doctors doctors = doctorRepository.getById(did);
		user.setDoctors(doctors);
		return userRepository.save(user);
	}
	
	@PostMapping("/userPatient")
	public User postPatientUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/user")
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	
}
