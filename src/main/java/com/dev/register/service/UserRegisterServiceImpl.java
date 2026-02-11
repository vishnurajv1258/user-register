package com.dev.register.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dev.register.dto.UserRegistrationRequest;
import com.dev.register.dto.UserRegistrationResponse;
import com.dev.register.entity.Users;
import com.dev.register.exception.UserRegistrationException;
import com.dev.register.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements UserRegisterService {

	private final UserRepository userRepository;

	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest registerRequest) {

		// Checking email id exists
		if (userRepository.existsByEmailid(registerRequest.getEmailid())) {
			throw new UserRegistrationException("Email already exists");
		}
		// Create new user object for saving

		Users user = Users.builder().emailid(registerRequest.getEmailid()).name(registerRequest.getName())
				.phoneno(registerRequest.getPhoneno()).password(registerRequest.getPassword()).build();

		Users savedUser = userRepository.save(user);

		UserRegistrationResponse resp = UserRegistrationResponse.builder().id(savedUser.getId())
				.emailid(savedUser.getEmailid()).name(savedUser.getName()).phoneno(savedUser.getPhoneno()).build();

		return resp;
	}

	@Override
	public List<UserRegistrationResponse> getAllUsers() {
		return List.of();
	}

}
