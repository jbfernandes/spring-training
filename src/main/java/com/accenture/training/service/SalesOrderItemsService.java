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

import com.accenture.training.domain.SalesOrderItemsEntity;
import com.accenture.training.dto.SalesOrderItemsTO;
import com.accenture.training.repository.SalesOrderItemsRepository;

@Service
public class SalesOrderItemsService {
	
	@Autowired
	SalesOrderItemsRepository rep;
		
	@Autowired
	ModelMapper mapper;
	
	
	
	public List<SalesOrderItemsTO> findAll(String status){
		List<SalesOrderItemsEntity> result = null;
		if (Strings.isEmpty(status)) {
			result = rep.findAll();
		} else {
			result = rep.findByStatusOrderByCreatedAtDesc(status);
		}
		
		return result.stream().map( item -> {
			return  mapper.map(item,  SalesOrderItemsTO.class);
		}).collect(Collectors.toList());
		
		/*
		return result.stream().map( item -> {
			SalesOrderItemItemsTO salesOrderItemItemsTO = item.getItems().stream().map(item -> {
				return mapper.map(item, SalesOrderItemItemsTO.class)
			});
			UsersTO userTO = mapper.map(item.getUser(), UsersTO.class);
			UsersTO userTO = mapper.map(item.getUser(), UsersTO.class);
			return  mapper.map(item,  SalesOrderItemsTO.class);
		}).collect(Collectors.toList());
		*/
	}




	public SalesOrderItemsTO save(SalesOrderItemsTO salesOrderItem) {
		SalesOrderItemsEntity salesOrderItemEntity = mapper.map(salesOrderItem, SalesOrderItemsEntity.class);
		
		if (Strings.isEmpty(salesOrderItemEntity.getId())){
			salesOrderItemEntity.setCreatedBy("app");
			salesOrderItemEntity.setCreatedAt(LocalDateTime.now());
		}
		salesOrderItemEntity.setModifiedBy("app");
		salesOrderItemEntity.setModifiedAt(LocalDateTime.now());
		
		SalesOrderItemsEntity savedEntity = rep.save(salesOrderItemEntity);
		return mapper.map(savedEntity, SalesOrderItemsTO.class);
	}




	public boolean delete(String id) {
		rep.deleteById(id);
		return true;
	}




	public SalesOrderItemsTO findById(String id) {
		Optional<SalesOrderItemsEntity> findById = rep.findById(id);
		if(findById.isPresent()){
			return mapper.map(findById.get(), SalesOrderItemsTO.class);
		}
		return null;
	}

}
