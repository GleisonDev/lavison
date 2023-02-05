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

@Table(name = "sections")
@Entity(name = "Section")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Section {

	public Section(CreateSectionData data) {
		this.name = data.name();
		this.margin = data.margin();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private BigDecimal margin;
	
	public void update(@Valid UpdateSectionData data) {
		if (data.margin() != null) {
			this.margin = data.margin();
		}
		
	}

}
