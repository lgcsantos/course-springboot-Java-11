package com.eduacandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduacandoweb.course.entities.Users;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<Users> findAll() {
		Users u = new Users (1L,"Maria", "Maria.jose@gmail.com", "99999-9999","12345" );
		return ResponseEntity.ok(u);
	}

}


