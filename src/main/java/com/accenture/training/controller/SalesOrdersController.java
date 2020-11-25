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

import com.accenture.training.dto.SalesOrdersTO;
import com.accenture.training.service.SalesOrdersService;

@RestController
@RequestMapping("/SalesOrder")
public class SalesOrdersController {

	@Autowired
	SalesOrdersService service;
	
	@GetMapping("")
	public List<SalesOrdersTO> findAll(@RequestParam(value="status", required=false) String status){
		return service.findAll(status);
	}
	
	@GetMapping("{salesOrderId}")
	public SalesOrdersTO findById(@PathVariable("salesOrderId") String id){
		return service.findById(id);
	}
	
	@PostMapping("")
	public SalesOrdersTO createSalesOrder(@RequestBody SalesOrdersTO salesOrder){
		return service.save(salesOrder);
	}
	
	@PutMapping("{salesOrderId}")
	public SalesOrdersTO updateSalesOrder(@PathVariable("salesOrderId") String id, @RequestBody SalesOrdersTO salesOrder){
		if(!id.equals(salesOrder.getId())){
			return new SalesOrdersTO();
		}
		
		return service.save(salesOrder);
	}
	
	@DeleteMapping("{salesOrderId}")
	public String deleteSalesOrder(@PathVariable("salesOrderId") String id){
		return Boolean.toString(service.delete(id));
	}

}
