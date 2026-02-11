package com.dev.register.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationRequest {

	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 50, message = "min 3 char required and max 50 char allowed")
	private String name;

	@NotBlank(message = "email is required")
	@Email(message = "Invalid email")
	@Size(min = 6, max = 50, message = "min 6 char required and max 50 char allowed")
	private String emailid;

	@NotBlank(message = "Phone no is required")
	@Size(min = 10, max = 12, message = "Invalid Phone No")
	private String phoneno;

	@NotBlank(message = "Password id required")
	@Size(min = 5, max = 50, message = "Invalid password length")
	private String password;

}
