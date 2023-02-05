package com.gvc.lavison.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record UpdateProductData(
		@NotNull
		Long id,
		String name,
		String section,
		BigDecimal price,
		BigDecimal cost,
		Integer amount) {

}
