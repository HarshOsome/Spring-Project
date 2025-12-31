package com.example.EnrollmentMgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EnrollmentMgmt.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	
	List<Enrollment> findByUserId(Long userId);
	List<Enrollment> findByCourseId(Long courseId);
	Optional<Enrollment> findByUserIdAndCourseId(Long userId, Long courseId);
	
	long countByCourseId(Long courseId);
	long countByUserId(Long userId);
	
}
