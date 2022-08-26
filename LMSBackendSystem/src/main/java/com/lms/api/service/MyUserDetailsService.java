package com.lms.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lms.api.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * go to DB and check whether this username is present or not
		 * If present Fetch the user details.
		 * If not present throw UsernameNotFoundException.
		 * 
		 */
		
		com.lms.api.model.User userDB = userRepository.findByUsername(username);
		if(userDB == null)
			throw new UsernameNotFoundException("Invalid Credentials");
			
		/*
		 * Convert Role to Authority
		 */
		List<GrantedAuthority> list = new ArrayList<>();
		String role = userDB.getRole();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
		list.add(authority);
		
		/*
		 * Pass user info from the DB to Spring Internal User that
		 * takes username , password and list of GrantedAuthorities
		 */
		
		User springUser = new User(userDB.getUsername(), userDB.getPassword(), list);
		
		return springUser;
	}
	
}



