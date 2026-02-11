package com.dev.register.service;

import java.util.List;

import com.dev.register.dto.UserRegistrationRequest;
import com.dev.register.dto.UserRegistrationResponse;

public interface UserRegisterService {
	
	UserRegistrationResponse registerUser(UserRegistrationRequest registerrequest);
	
	List<UserRegistrationResponse> getAllUsers();

}
