package com.example.EnrollmentMgmt.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

@Table(name = "progress", uniqueConstraints = {
		@UniqueConstraint(name = "uk_progress_enrollment_module", columnNames = { "enrollment_id",
				"module_id" }) }, indexes = { @Index(name = "idx_progress_enrollment", columnList = "enrollment_id"),
						@Index(name = "idx_progress_module", columnList = "module_id")

})
public class Progress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "enrollment_id", nullable = false)
	private Long enrollmentId;

	@NotNull
	@Column(name = "module_id ", nullable = false)
	private Long moduleId;

	@Min(0)
	@Max(100)
	private int completionPercent = 0;

	private LocalDateTime lastViewedAt;

}
