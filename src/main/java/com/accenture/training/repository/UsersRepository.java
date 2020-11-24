package com.accenture.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.training.domain.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, String>{
	

	public List<UsersEntity> findByNameOrderByNameAsc(String name);
	
	@Query("Select k from UsersEntity as k where k.name like :keyword")
	public List<UsersEntity> findByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT k FROM UsersEntity k WHERE function('contains', k.name , :keyword, function('fuzzy', 0.5)) = function('contains_rhs')")
	public List<UsersEntity> findByKeywordWithFuzzy(@Param("keyword") String keyword);
	
}
