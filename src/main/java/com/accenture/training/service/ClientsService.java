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

import com.accenture.training.domain.ClientsEntity;
import com.accenture.training.dto.ClientsTO;
import com.accenture.training.repository.ClientsRepository;

@Service
public class ClientsService {
	
	@Autowired
	ClientsRepository rep;
	
	
	@Autowired
	ModelMapper mapper;

	
	
	
	public List<ClientsTO> findAll(String keyword, boolean fuzzy){
		List<ClientsEntity> result = null;
		if (Strings.isEmpty(keyword)) {
			result = rep.findAll();
		} else if (fuzzy) {
			result = rep.findByKeywordWithFuzzy(keyword);
		} else {
			/*
			ClientsEntity exampleEntity = new ClientsEntity();
			exampleEntity.setName(keyword);
			Example<ClientsEntity> example = Example.of(exampleEntity);
			result = rep.findAll(example);´
			*/
			result = rep.findByKeyword("%" + keyword + "%");
		}
		
		return result.stream().map( item -> {
			return  mapper.map(item,  ClientsTO.class);
		}).collect(Collectors.toList());
	}




	public ClientsTO save(ClientsTO client) {
		if (Strings.isEmpty(client.getId())){
			client.setCreatedBy("app");
			client.setCreatedAt(LocalDateTime.now().toString());
		}
		client.setModifiedBy("app");
		client.setModifiedAt(LocalDateTime.now().toString());
		
		ClientsEntity savedEntity = rep.save(mapper.map(client, ClientsEntity.class));
		return mapper.map(savedEntity, ClientsTO.class);
	}




	public boolean delete(String id) {
		rep.deleteById(id);
		return true;
	}




	public ClientsTO findById(String id) {
		Optional<ClientsEntity> findById = rep.findById(id);
		if(findById.isPresent()){
			return mapper.map(findById.get(), ClientsTO.class);
		}
		return null;
	}

}
