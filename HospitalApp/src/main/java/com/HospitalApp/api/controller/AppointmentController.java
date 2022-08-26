package com.HospitalApp.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.HospitalApp.api.model.Appointment;
import com.HospitalApp.api.model.Doctors;
import com.HospitalApp.api.repository.AppointmentRepository;
import com.HospitalApp.api.repository.DoctorRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class AppointmentController {
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@PostMapping("/appointment/{did}")
	public Appointment postAppointment(@PathVariable("did")Long did,
								@RequestBody Appointment appointment ) {
		
		Doctors doctor = doctorRepository.getById(did);
		appointment.setDoctor(doctor);
		
		return appointmentRepository.save(appointment);
	}
	
	@GetMapping("/appointment/{did}")
	public List<Appointment> getListOfPatient(@PathVariable("did")Long did) {
		List<Appointment> list = new ArrayList<>();
		list = appointmentRepository.findByDoctorsId(did);
		return list;
	}
	
//	@GetMapping("/appointment/{did}/{username}")
//	public void getAppointment(@PathVariable("did")Long did, @PathVariable("username")String username) {
//		
//	}
	 
	
}
