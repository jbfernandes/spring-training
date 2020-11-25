package com.accenture.training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.training.domain.SalesOrdersEntity;

public interface SalesOrdersRepository extends JpaRepository<SalesOrdersEntity, String>{
	
	@Query("Select k from SalesOrdersEntity as k join fetch k.items as i")
	public List<SalesOrdersEntity> internalFindAll();
	
	@Query("Select k from SalesOrdersEntity as k left join fetch k.items as i where k.id = :id")
	public SalesOrdersEntity internalFindById(@Param("id") String id);
	
	public List<SalesOrdersEntity> findByStatusOrderByCreatedAtDesc(String status);	
	
}
