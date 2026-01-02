
// CourseMgmt/dto/CourseResponse.java
package com.example.CourseMgmt.dto;

import java.time.LocalDateTime;
import lombok.Getter; 
import lombok.Setter;

@Getter @Setter
public class CourseResponse {
    private Long id;
    private String title;
    private String description;
    private String status;          // c.getStatus().name()
    private Integer estimatedHours;
    private Long instructorUserId;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
