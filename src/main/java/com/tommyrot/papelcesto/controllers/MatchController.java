package com.tommyrot.papelcesto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tommyrot.papelcesto.dto.Match;
import com.tommyrot.papelcesto.dto.create.CreateMatch;
import com.tommyrot.papelcesto.dto.update.UpdateMatch;
import com.tommyrot.papelcesto.usecase.CrudMatchUseCase;

@RestController
@RequestMapping(value = "matches")
public class MatchController {

  private final CrudMatchUseCase crudMatchUseCase;

  @Autowired
  public MatchController(CrudMatchUseCase crudMatchUseCase) {
    super();
    this.crudMatchUseCase = crudMatchUseCase;
  }

  @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
  public Match getMatchById(@PathVariable("id") Integer id) {
    return crudMatchUseCase.getMatchById(id);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Match> getAllMatches() {
    return crudMatchUseCase.getAllMatches();
  }

  @RequestMapping(value = "{date}", method = RequestMethod.POST)
  public ResponseEntity<Match> createMatch(@RequestBody CreateMatch createMatch) {
    return new ResponseEntity<Match>(crudMatchUseCase.createNewMatch(createMatch),
        HttpStatus.CREATED);
  }

  @RequestMapping(value = "{id:\\d+}", method = RequestMethod.PUT)
  public Match updateMatch(@PathVariable("id") Integer id, @RequestBody UpdateMatch updateMatch) {
    return crudMatchUseCase.updateMatch(id, updateMatch);
  }

  @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
  public void deleteMatch(@PathVariable("id") Integer id) {
    crudMatchUseCase.deleteMatch(id);
  }

}
