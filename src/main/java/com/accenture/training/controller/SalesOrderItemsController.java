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

import com.accenture.training.dto.SalesOrderItemsTO;
import com.accenture.training.service.SalesOrderItemsService;

@RestController
@RequestMapping("/SalesOrderItem")
public class SalesOrderItemsController {

	@Autowired
	SalesOrderItemsService service;
	
	@GetMapping("")
	public List<SalesOrderItemsTO> findAll(@RequestParam(value="status", required=false) String status){
		return service.findAll(status);
	}
	
	@GetMapping("{salesOrderItemId}")
	public SalesOrderItemsTO findById(@PathVariable("salesOrderItemId") String id){
		return service.findById(id);
	}
	
	@PostMapping("")
	public SalesOrderItemsTO createSalesOrderItem(@RequestBody SalesOrderItemsTO salesOrderItem){
		return service.save(salesOrderItem);
	}
	
	@PutMapping("{salesOrderItemId}")
	public SalesOrderItemsTO updateSalesOrderItem(@PathVariable("salesOrderItemId") String id, @RequestBody SalesOrderItemsTO salesOrderItem){
		if(!id.equals(salesOrderItem.getId())){
			return new SalesOrderItemsTO();
		}
		
		return service.save(salesOrderItem);
	}
	
	@DeleteMapping("{salesOrderItemId}")
	public String deleteSalesOrderItem(@PathVariable("salesOrderItemId") String id){
		return Boolean.toString(service.delete(id));
	}

}
