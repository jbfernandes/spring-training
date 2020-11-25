package com.accenture.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.training.domain.SalesOrderItemsEntity;
import com.accenture.training.domain.SalesOrdersEntity;

public interface SalesOrderItemsRepository extends JpaRepository<SalesOrderItemsEntity, String>{
	
	public List<SalesOrderItemsEntity> findByStatusOrderByCreatedAtDesc(String status);	
	
}
