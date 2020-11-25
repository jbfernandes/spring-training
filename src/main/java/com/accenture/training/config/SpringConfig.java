package com.accenture.training.config;

import java.time.LocalDateTime;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	
	 @Bean
	 public ModelMapper modelMapper(){
		 ModelMapper modelMapper = new ModelMapper();
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 modelMapper.addConverter(new AbstractConverter<String, LocalDateTime>() {
		 	@Override
			protected LocalDateTime convert(String source) {
		 		LocalDateTime localDate = LocalDateTime.parse(source);
				return localDate;
		 	}
	 	});
		 return modelMapper;
	 }
	 
}
