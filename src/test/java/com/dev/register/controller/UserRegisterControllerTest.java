package com.dev.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.dev.register.service.UserRegisterService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(UserRegisterController.class)
public class UserRegisterControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	/*
	 * @MockBean private UserRegisterService userRegisterService;
	 */

}
