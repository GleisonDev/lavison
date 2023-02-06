package com.gvc.lavison.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateProductData(
		
		@NotBlank
		String name,
		@NotBlank
		String brand,
		@NotBlank
		String section,
		BigDecimal price,
		@NotNull
		BigDecimal cost,
		Integer amount) {

}
