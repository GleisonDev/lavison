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

import com.gvc.lavison.product.CreateProductData;
import com.gvc.lavison.product.ListProductData;
import com.gvc.lavison.product.Product;
import com.gvc.lavison.product.ProductRepository;
import com.gvc.lavison.product.UpdateProductData;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@PostMapping
	@Transactional
	public void registerProduct(@RequestBody @Valid CreateProductData data) {
		
		repository.save(new Product(data));
	}
	
	@GetMapping
	public Page<ListProductData> listProduct(@PageableDefault(size = 10, sort = {"name"}) Pageable page){
		
		return repository.findAll(page).map(ListProductData::new);
	}
	
	@PutMapping
	@Transactional
	public void updateProduct(@RequestBody @Valid UpdateProductData data) {
		Product product = repository.getReferenceById(data.id());
		
		product.update(data);
		
	}

}
