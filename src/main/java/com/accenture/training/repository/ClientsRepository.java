package com.accenture.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.training.domain.ClientsEntity;

public interface ClientsRepository extends JpaRepository<ClientsEntity, String>{
	

	public List<ClientsEntity> findByNameOrderByNameAsc(String name);
	
	@Query("Select k from ClientsEntity as k where k.name like :keyword")
	public List<ClientsEntity> findByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT k FROM ClientsEntity k WHERE function('contains', k.name , :keyword, function('fuzzy', 0.5)) = function('contains_rhs') or function('contains', k.familyName , :keyword, function('fuzzy', 0.5)) = function('contains_rhs') ")
	public List<ClientsEntity> findByKeywordWithFuzzy(@Param("keyword") String keyword);
	
}
