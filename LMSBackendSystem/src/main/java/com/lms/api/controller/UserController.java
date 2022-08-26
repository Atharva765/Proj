package com.lms.api.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lms.api.dto.UserDto;
import com.lms.api.model.LearningTrack;
import com.lms.api.model.User;
import com.lms.api.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/user/register")
	public User register(@RequestBody User user) {
		user.setPassword( passwordEncoder.encode(user.getPassword())); 
		return userRepository.save(user);
	}
	
	@GetMapping("/user/login")
	public UserDto login(Principal principal) {
		String username = principal.getName();
		User user = userRepository.findByUsername(username);
		UserDto userDto = new UserDto();
		userDto = userDto.convert(user);
		return userDto;
	}
	/*
	 * User Profile Update name, mobile, city
	 */
	@PutMapping("/user/update/{id}")
	public UserDto updateUserProfile(@PathVariable("id") Long id, @RequestBody User userNew) {
		/*
		 * Step 1 : Take the ID of User that has to be updated : id
		 * Step 2 :Go to Db and fetch the record for this ID : userDB
		 * Step 3: Read new User details/values from the user : userNew
		 * Step 4: update userDB with new values: userDB<--userNew
		 */
		User user  = userRepository.getById(id);
		
		if(userNew.getName()!= null)	
			user.setName(userNew.getName());
		if(userNew.getMobile()!=null)
			user.setMobile(userNew.getMobile());
		if(userNew.getCity()!=null)
			user.setCity(userNew.getCity());
		
		userRepository.save(user);
		UserDto dto = new UserDto();
		dto = dto.convert(user);
		
		return dto;
	}

	
	
	
	
}
