package com.indico.kirimaja.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indico.kirimaja.user.dto.request.LoginRequest;
import com.indico.kirimaja.user.dto.response.UserResponse;

@RestController
@RequestMapping("/${spring.application.name}/*")
public class AuthorizationController {

	private static final Logger LOG = LoggerFactory.getLogger(AuthorizationController.class);
	
	@PostMapping("${indico.controllers.url.login}")
	public ResponseEntity<UserResponse> login(@RequestBody LoginRequest login, HttpServletRequest request, HttpServletResponse response){
		LOG.info("AuthorizationController.login(). Username: {}", login.getUsername());
		return null;
	}
}
