package com.tommyrot.papelcesto.mappers.performance;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.dto.Performance;
import com.tommyrot.papelcesto.dto.create.CreatePerformance;

@Component
public class CreatePerformanceToPerformanceMapper {
	
	public Performance map(CreatePerformance source){
		
		Performance result = new Performance();
		
		result.setId(source.getId());
		result.setScore(source.getScore());

		return result;
		
	}

}
