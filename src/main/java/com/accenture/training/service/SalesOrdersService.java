package com.accenture.training.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.accenture.training.domain.SalesOrdersEntity;
import com.accenture.training.dto.SalesOrderItemsTO;
import com.accenture.training.dto.SalesOrdersTO;
import com.accenture.training.repository.SalesOrderItemsRepository;
import com.accenture.training.repository.SalesOrdersRepository;

@Service
public class SalesOrdersService {
	
	@Autowired
	SalesOrdersRepository rep;
	
	@Autowired
	SalesOrderItemsRepository itemsRep;
		
	@Autowired
	ModelMapper mapper;
	
	
	
	public List<SalesOrdersTO> findAll(String status){
		List<SalesOrdersEntity> result = null;
		if (Strings.isEmpty(status)) {
			result = rep.internalFindAll();
		} else {
			result = rep.findByStatusOrderByCreatedAtDesc(status);
		}
		
		return result.stream().map( item -> {
			SalesOrdersTO salesOrder = mapper.map(item,  SalesOrdersTO.class);
			
			List<SalesOrderItemsTO> collect = item.getItems().stream().map(salesOrderItem -> {
				return mapper.map(salesOrderItem, SalesOrderItemsTO.class);
			}).collect(Collectors.toList());
			
			salesOrder.setItems(collect);
			
			return salesOrder;
		}).collect(Collectors.toList());
	}

	

	public SalesOrdersTO findById(String id) {
		SalesOrdersEntity findById = rep.internalFindById(id);
		if(findById != null){
			SalesOrdersTO salesOrder = mapper.map(findById, SalesOrdersTO.class);

			List<SalesOrderItemsTO> collect = salesOrder.getItems().stream().map(salesOrderItem -> {
				return mapper.map(salesOrderItem, SalesOrderItemsTO.class);
			}).collect(Collectors.toList());
			
			salesOrder.setItems(collect);
			
			return salesOrder;
		}
		return null;
	}



	public SalesOrdersTO save(SalesOrdersTO salesOrder) {
		SalesOrdersEntity salesOrderEntity = mapper.map(salesOrder, SalesOrdersEntity.class);
		
		if (Strings.isEmpty(salesOrderEntity.getId())){
			salesOrderEntity.setCreatedBy("app");
			salesOrderEntity.setCreatedAt(LocalDateTime.now());
		}
		salesOrderEntity.setModifiedBy("app");
		salesOrderEntity.setModifiedAt(LocalDateTime.now());
		
		SalesOrdersEntity savedEntity = rep.save(salesOrderEntity);
		
		salesOrderEntity.getItems().stream().forEach(item -> item.setSalesOrder(savedEntity));		
		itemsRep.saveAll(salesOrderEntity.getItems());
		
		return mapper.map(savedEntity, SalesOrdersTO.class);
	}




	public boolean delete(String id) {
		rep.deleteById(id);
		return true;
	}



}
