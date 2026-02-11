package com.dev.register.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.register.dto.UserRegistrationRequest;
import com.dev.register.dto.UserRegistrationResponse;
import com.dev.register.service.UserRegisterService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRegisterController {

	private final UserRegisterService userRegisterService;

	@PostMapping("/register")
	public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody @Valid UserRegistrationRequest registrationReq) {
		UserRegistrationResponse response = userRegisterService.registerUser(registrationReq);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
