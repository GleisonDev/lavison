package com.gvc.lavison.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record UpdateSectionData(
		@NotNull
		Long id,
		BigDecimal margin) {

}
