package com.tommyrot.papelcesto.mappers.performance;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.domain.PerformanceEntity;
import com.tommyrot.papelcesto.dto.Performance;

@Component
public class PerformanceEntityToPerformanceMapper {
	
	public Performance map(PerformanceEntity source){
		
		Performance result = new Performance();
		
		result.setId(source.getId());
		result.setScore(source.getScore());

		return result;
		
	}

}
