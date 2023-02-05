package com.gvc.lavison.product;

public record ListSectionData(Long id, String name) {
	
	public ListSectionData(Section section) {
		this(section.getId(), section.getName());
	}

}
