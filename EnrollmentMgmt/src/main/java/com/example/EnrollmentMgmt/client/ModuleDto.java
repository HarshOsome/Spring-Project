package com.example.EnrollmentMgmt.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown =true)

public class ModuleDto {
	private Long id;
	private String title;
	private Integer orderIndex;
	private Long courseId;
}
