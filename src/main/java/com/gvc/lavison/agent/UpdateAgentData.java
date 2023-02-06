package com.gvc.lavison.agent;

import jakarta.validation.constraints.NotNull;

public record UpdateAgentData(
		@NotNull
		Long id,
		String password,
		String phone,
		Acess acess) {

}
