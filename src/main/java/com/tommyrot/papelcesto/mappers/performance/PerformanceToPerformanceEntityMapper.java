package com.tommyrot.papelcesto.mappers.performance;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.domain.PerformanceEntity;
import com.tommyrot.papelcesto.dto.Performance;

@Component
public class PerformanceToPerformanceEntityMapper {

  public PerformanceEntity map(Performance source) {

    PerformanceEntity result = new PerformanceEntity();

    result.setId(source.getId());
    result.setScore(source.getScore());

    return result;

  }

}
