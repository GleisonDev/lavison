package com.gvc.lavison.agent;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CreateAgentData(
		
		@NotBlank
		String name,
		@NotBlank
		String login, 
		@NotBlank
		@Pattern(regexp = "\\d{6}")
		String password,
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String phone, 
		@NotBlank
		@Email
		String email,
		@NotBlank
		Acess acess) {

}
