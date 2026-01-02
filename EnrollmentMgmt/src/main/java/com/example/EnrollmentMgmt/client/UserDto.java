
// EnrollmentMgmt/client/UserDto.java
package com.example.EnrollmentMgmt.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String fullName;
    private String role; // "STUDENT" | "INSTRUCTOR" | "ADMIN"
}
