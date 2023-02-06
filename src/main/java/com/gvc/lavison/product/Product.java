package com.gvc.lavison.product;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "products")
@Entity(name = "Product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
	
	public Product(CreateProductData data) {
		this.name = data.name();
		this.brand = data.brand();
		this.section = data.section();
		this.price = data.price();
		this.cost = data.cost();
		this.amount = data.amount();
		this.active = true;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private String section;
	private BigDecimal price;
	private BigDecimal cost;
	private Integer amount;
	private boolean active;
	
	public void update(@Valid UpdateProductData data) {
		if (data.name() != null) {
			this.name = data.name();
		}
		if (data.section() != null) {
			this.section = data.section();
		}
		if (data.price() != null) {
			this.price = data.price();
		}
		if (data.cost() != null) {
			this.cost = data.cost();
		}
		if (data.amount() != null) {
			this.amount = data.amount();
		}
		
	}

	public void delete() {
		this.active = false;
		
	}

}
