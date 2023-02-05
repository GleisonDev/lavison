package com.gvc.lavison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gvc.lavison.product.CreateSectionData;
import com.gvc.lavison.product.ListSectionData;
import com.gvc.lavison.product.Section;
import com.gvc.lavison.product.SectionRepository;
import com.gvc.lavison.product.UpdateSectionData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	private SectionRepository repository;
	
	@PostMapping
	@Transactional
	public void registerSection(@RequestBody @Valid CreateSectionData data) {
		
		repository.save(new Section(data));
	}

	@GetMapping
	public Page<ListSectionData> listSection(@PageableDefault(size = 10, sort = {"name"}) Pageable page){
		
		return repository.findAll(page).map(ListSectionData::new);
	}
	
	@PutMapping
	@Transactional
	public void updateSection(@RequestBody @Valid UpdateSectionData data){
		Section section = repository.getReferenceById(data.id());
		
		section.update(data);
		
	}
}
