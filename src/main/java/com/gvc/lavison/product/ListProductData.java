package com.gvc.lavison.product;

import java.math.BigDecimal;

public record ListProductData(Long id, String name, String brand, String section, BigDecimal price, Integer amount) {

	public ListProductData(Product product) {
		this(product.getId(), product.getName(), product.getBrand(), product.getSection(), product.getPrice(), product.getAmount());
	}
}

