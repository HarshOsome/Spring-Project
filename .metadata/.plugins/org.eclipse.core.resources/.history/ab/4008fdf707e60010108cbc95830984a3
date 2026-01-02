package com.example.UserMgmt.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.UserMgmt.dto.AddressRequest;
import com.example.UserMgmt.dto.CreateUserRequest;
import com.example.UserMgmt.entity.Address;
import com.example.UserMgmt.entity.Users;
import com.example.UserMgmt.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public Users createUser(CreateUserRequest req, AddressRequest address)   {
		Optional<Users> existing = userRepository.findByEmail(req.getEmail());
	
		Users u = new Users();
		u.setFullName(req.getFullName());
		u.setEmail(req.getEmail());
		u.setPasswordHash(req.getPasswordHash());
		u.setRole(req.getRole());

		if (address != null) {
			Address a = new Address();
			a.setLine1(address.getLine1());
			a.setLine2(address.getLine2());
			a.setCity(address.getCity());
			a.setState(address.getState());
			a.setCountry(address.getCountry());
			a.setPostalCode(address.getPostalCode());
			u.setAddress(a);

		}
		return userRepository.save(u);
	}

}
