
package com.example.UserMgmt.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.UserMgmt.dto.CreateUserRequest;
import com.example.UserMgmt.entity.Address;
import com.example.UserMgmt.entity.Users;
import com.example.UserMgmt.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Users> create(@Valid @RequestBody CreateUserRequest req) {
		Users saved = userService.createUser(req, req.getAddress());
		return ResponseEntity.ok(saved);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Users> getById(@PathVariable Long id) throws BadRequestException 
	{
		Users users = userService.getUserById(id);
		return ResponseEntity.ok(users);
	}
	@GetMapping("/{id}/address")
	public ResponseEntity<Address> getByAddressByUserId(@PathVariable Long id) throws BadRequestException{
		Users user = userService.getUserById(id);
		Address address = user.getAddress();
		return ResponseEntity.ok(address);
		
	}

}
