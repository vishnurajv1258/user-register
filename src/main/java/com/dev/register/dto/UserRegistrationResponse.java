package com.dev.register.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor @Builder
public class UserRegistrationResponse {

	private Long id;

	private String name;

	private String emailid;

	private String phoneno;
}
