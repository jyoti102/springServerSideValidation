package com.techknow.ssv.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techknow.ssv.model.User;

/**
 * @author JyotiSingh
 *
 */
@RestController
@RequestMapping(value = "users")
public class UserController {

	@PostMapping
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		System.out.println("User validated successfully");
		return ResponseEntity.created(null).build();
	}

}
