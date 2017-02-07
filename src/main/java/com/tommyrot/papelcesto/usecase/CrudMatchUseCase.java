package com.tommyrot.papelcesto.usecase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.domain.MatchEntity;
import com.tommyrot.papelcesto.dto.Match;
import com.tommyrot.papelcesto.dto.create.CreateMatch;
import com.tommyrot.papelcesto.dto.update.UpdateMatch;
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

    MatchEntity matchToReturn = matchRepository.findOne(id);
    Match target = mapper.toMatch(matchToReturn);

    return target;
  }

  public List<Match> getAllMatches() {

    List<MatchEntity> matchList = matchRepository.findAll();
    List<Match> listToReturn = new LinkedList<Match>();

    for (MatchEntity match : matchList) {
      listToReturn.add(mapper.toMatch(match));
    }

    return listToReturn;
  }

  public Match createNewMatch(CreateMatch createMatch) {

    MatchEntity matchToCreate = mapper.toMatchEntity(createMatch);
    matchRepository.save(matchToCreate);

    return mapper.toMatch(matchToCreate);
  }

  public Match updateMatch(Integer id, UpdateMatch updateMatch) {

    MatchEntity matchToUpdate = matchRepository.findOne(id);
    mapper.updateMatchEntity(matchToUpdate, updateMatch);

    return mapper.toMatch(matchToUpdate);
  }

  public void deleteMatch(Integer id) {
    matchRepository.delete(id);
  }



}
