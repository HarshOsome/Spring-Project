
package com.example.EnrollmentMgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EnrollmentMgmt.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    List<Progress> findByEnrollmentId(Long enrollmentId);

    List<Progress> findByModuleId(Long moduleId);

    Optional<Progress> findByEnrollmentIdAndModuleId(Long enrollmentId, Long moduleId);

    long countByEnrollmentId(Long enrollmentId);
}
