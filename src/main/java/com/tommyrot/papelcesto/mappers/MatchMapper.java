package com.tommyrot.papelcesto.mappers;

import com.tommyrot.papelcesto.domain.MatchEntity;
import com.tommyrot.papelcesto.dto.Match;

public class MatchMapper {

  public Match toMatchEntity(Integer id) {
    MatchEntity source = new MatchEntity();
    Match target = new Match();

    target.setId(id);
    target.setDate(source.getDate());

    return target;
  }

}
