package com.gvc.lavison.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSectionData(
		
		@NotBlank
		String name,
		@NotNull
		BigDecimal margin) {

}
