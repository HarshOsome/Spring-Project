
package com.example.CourseMgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CourseMgmt.entity.Course;
import com.example.CourseMgmt.entity.Course.Status;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContainingIgnoreCase(String title);

    List<Course> findByInstructorUserIdAndStatus(Long instructorUserId, Status status);

    List<Course> findByInstructorUserId(Long instructorUserId);

    List<Course> findByStatus(Status status);

    Optional<Course> findByInstructorUserIdAndTitleIgnoreCase(Long instructorUserId, String title);
}
