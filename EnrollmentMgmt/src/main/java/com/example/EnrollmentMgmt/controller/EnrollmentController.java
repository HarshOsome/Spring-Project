package com.example.EnrollmentMgmt.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnrollmentMgmt.entity.Enrollment;
import com.example.EnrollmentMgmt.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
	private final EnrollmentService service;
	
	@PostMapping
	public ResponseEntity<Enrollment> enroll(@RequestParam Long userId, @RequestParam Long courseId){
		return ResponseEntity.ok(service.enroll(userId, courseId));
	}
	@PatchMapping("/cancel")
	public ResponseEntity<Void> cancel(@RequestParam Long userId, @RequestParam Long courseId){
		service.cancel(userId, courseId);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("/by-user/{userId}")
	public ResponseEntity<List<Enrollment>> byUser(@PathVariable Long userId){
		return ResponseEntity.ok(service.getByUser(userId));
	}
	
	@GetMapping("/by-course/{courseId}")
	public ResponseEntity<List<Enrollment>> byCourse(@PathVariable Long courseId){
		return ResponseEntity.ok(service.getByCourse(courseId));
	}
	
	
}
