package com.accenture.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.training.dto.ProductsTO;
import com.accenture.training.service.ProductsService;

@RestController
@RequestMapping("/Product")
public class ProductsController {

	@Autowired
	ProductsService service;
	
	@GetMapping("")
	public List<ProductsTO> findAll(@RequestParam(value="keyword", required=false) String keyword, @RequestParam(value="fuzzy", required=false) boolean fuzzy){
		return service.findAll(keyword, fuzzy);
	}
	
	@GetMapping("{productId}")
	public ProductsTO findById(@PathVariable("productId") String id){
		return service.findById(id);
	}
	
	@PostMapping("")
	public ProductsTO createProduct(@RequestBody ProductsTO product){
		return service.save(product);
	}
	
	@PutMapping("{productId}")
	public ProductsTO updateProduct(@PathVariable("productId") String id, @RequestBody ProductsTO product){
		if(!id.equals(product.getId())){
			return new ProductsTO();
		}
		
		return service.save(product);
	}
	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable("productId") String id){
		return Boolean.toString(service.delete(id));
	}

}
