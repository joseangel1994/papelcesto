package com.tommyrot.papelcesto.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.dto.Match;
import com.tommyrot.papelcesto.mappers.MatchMapper;
import com.tommyrot.papelcesto.repositories.MatchRepository;

@Service
public class CrudMatchUseCase {

  private final MatchRepository matchRepository;
  private final MatchMapper mapper;

  @Autowired
  public CrudMatchUseCase(MatchRepository matchRepository, MatchMapper mapper) {
    super();
    this.matchRepository = matchRepository;
    this.mapper = mapper;
  }

  public Match getMatchById(Integer id) {

    Match target = mapper.toMatchEntity(id);

    return target;
  }



}
