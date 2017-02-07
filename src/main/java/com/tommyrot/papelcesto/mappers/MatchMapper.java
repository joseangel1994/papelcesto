package com.tommyrot.papelcesto.mappers;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.domain.MatchEntity;
import com.tommyrot.papelcesto.dto.Match;
import com.tommyrot.papelcesto.dto.create.CreateMatch;
import com.tommyrot.papelcesto.dto.update.UpdateMatch;

@Component
public class MatchMapper {

  public Match toMatch(MatchEntity source) {

    Match target = new Match();

    target.setId(source.getId());
    target.setDate(source.getDate());

    return target;
  }

  public MatchEntity toMatchEntity(CreateMatch source) {

    MatchEntity matchToCreate = new MatchEntity();

    matchToCreate.setDate(source.getDate());

    return matchToCreate;
  }

  public MatchEntity updateMatchEntity(MatchEntity matchToUpdate, UpdateMatch updateMatch) {

    matchToUpdate.setDate(updateMatch.getDate());

    return matchToUpdate;
  }



}
