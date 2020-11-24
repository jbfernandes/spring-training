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

import com.accenture.training.domain.UsersEntity;
import com.accenture.training.dto.UsersTO;
import com.accenture.training.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository rep;
	
	
	@Autowired
	ModelMapper mapper;

	
	
	
	public List<UsersTO> findAll(String keyword, boolean fuzzy){
		List<UsersEntity> result = null;
		if (Strings.isEmpty(keyword)) {
			result = rep.findAll();
		} else if (fuzzy) {
			result = rep.findByKeywordWithFuzzy(keyword);
		} else {
			/*
			UsersEntity exampleEntity = new UsersEntity();
			exampleEntity.setName(keyword);
			Example<UsersEntity> example = Example.of(exampleEntity);
			result = rep.findAll(example);´
			*/
			result = rep.findByKeyword("%" + keyword + "%");
		}
		
		return result.stream().map( item -> {
			return  mapper.map(item,  UsersTO.class);
		}).collect(Collectors.toList());
	}




	public UsersTO save(UsersTO user) {
		if (Strings.isEmpty(user.getId())){
			user.setCreatedBy("app");
			user.setCreatedAt(LocalDateTime.now().toString());
		}
		user.setModifiedBy("app");
		user.setModifiedAt(LocalDateTime.now().toString());
		
		UsersEntity savedEntity = rep.save(mapper.map(user, UsersEntity.class));
		return mapper.map(savedEntity, UsersTO.class);
	}




	public boolean delete(String id) {
		rep.deleteById(id);
		return true;
	}




	public UsersTO findById(String id) {
		Optional<UsersEntity> findById = rep.findById(id);
		if(findById.isPresent()){
			return mapper.map(findById.get(), UsersTO.class);
		}
		return null;
	}

}
