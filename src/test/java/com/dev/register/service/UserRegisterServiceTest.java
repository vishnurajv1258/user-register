package com.dev.register.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dev.register.dto.UserRegistrationRequest;
import com.dev.register.dto.UserRegistrationResponse;
import com.dev.register.entity.Users;
import com.dev.register.exception.UserRegistrationException;
import com.dev.register.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
public class UserRegisterServiceTest {
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserRegisterServiceImpl userRegisterService;

	@Test
	void registerUser_success() {
		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setEmailid("test@test.com");
		request.setName("testName");
		request.setPhoneno("9876543210");
		request.setPassword("testPassword");

		Users savedUser = Users.builder().id(1L).emailid("testmail@tt.com").name("testName").phoneno("9876543210")
				.password("pass@123").build();

		// Mocking dependencies
		// when(userRepository.existsByEmail(Mockito.anyString().toString())).thenReturn(false);
		when(userRepository.save(Mockito.any(Users.class))).thenReturn(savedUser);

		// Act
		UserRegistrationResponse response = userRegisterService.registerUser(request);

		// Assert
		assertNotNull(response);
		assertEquals("test@example.com", response.getEmailid());
		verify(userRepository, times(1)).save(Mockito.any());
	}

	@Test
	void rregisterUser_ThrowsException_WhenEmailExists() {
		// Arrange missing name and invalid email

		// Arrange
		UserRegistrationRequest request = new UserRegistrationRequest();
		request.setEmailid("duplicate@example.com");

		when(userRepository.existsByEmailid("duplicate@example.com")).thenReturn(true);

		// Act & Assert
		assertThrows(UserRegistrationException.class, () -> userRegisterService.registerUser(request));
		verify(userRepository, never()).save(Mockito.any());

	}

}
