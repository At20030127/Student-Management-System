package com.example.student_management_system.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	private Long id;
	@NotEmpty(message="Enter the first name..")
	private String firstName;
	@NotEmpty(message="Enter the last name..")
	private String lastName;
	@NotEmpty(message = "Email should not be empty..")
	private String email;
}
