package com.example.UserMgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserMgmt.entity.Users;
import com.example.UserMgmt.entity.Users.Role;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);
	List<Users> findByFullNameContainingIgnoreCase(String namePart);
	
	List<Users> findByRole(Role role);
	
	boolean existsByEmail(String email);	
	
}
