
package com.example.CourseMgmt.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.CourseMgmt.dto.CourseResponse;
import com.example.CourseMgmt.dto.CreateCourseRequest;
import com.example.CourseMgmt.entity.Course;
import com.example.CourseMgmt.entity.Modules;
import com.example.CourseMgmt.repository.ModulesRepository;
import com.example.CourseMgmt.service.CourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/courses")
@Validated
public class CourseController {

	private final CourseService courseService;
	private final ModulesRepository moduleRepository;

	// @Autowired optional; single-ctor is autowired automatically
	public CourseController(CourseService courseService, ModulesRepository moduleRepository) {
		this.courseService = courseService;
		this.moduleRepository = moduleRepository;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> create(@Valid @RequestBody CreateCourseRequest req) {
		Course saved = courseService.createCourse(req);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CourseResponse> get(@PathVariable Long id) {
		Course c = courseService.getCourse(id);
		CourseResponse dto = new CourseResponse();
		dto.setId(c.getId());
		dto.setTitle(c.getTitle());
		dto.setDescription(c.getDescription());
		dto.setStatus(c.getStatus().name());
		dto.setEstimatedHours(c.getEstimatedHours());
		dto.setInstructorUserId(c.getInstructorUserId());
		dto.setCreatedAt(c.getCreatedAt());
		dto.setUpdateAt(c.getUpdateAt());
		return ResponseEntity.ok(dto);
	}

	@GetMapping("/{id}/modules")
	public ResponseEntity<List<Modules>> getModules(@PathVariable Long id) {
		List<Modules> modules = moduleRepository.findByCourseIdOrderByOrderIndexAsc(id);
		return ResponseEntity.ok(modules);
	}
}
