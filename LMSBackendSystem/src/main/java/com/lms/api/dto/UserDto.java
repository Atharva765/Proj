package com.lms.api.dto;

import com.lms.api.model.User;

public class UserDto {
	
	private Long id;
	private String name;
	private String mobile;
	private String email;
	private String city;
	private String username;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserDto convert(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setCity(user.getCity());
		userDto.setEmail(user.getEmail());
		userDto.setMobile(user.getMobile());
		userDto.setName(user.getName());
		userDto.setUsername(user.getUsername());
		return userDto;
	}

}
