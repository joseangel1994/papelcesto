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

import com.tommyrot.papelcesto.dto.Competition;
import com.tommyrot.papelcesto.dto.create.CreateCompetition;
import com.tommyrot.papelcesto.dto.update.UpdateCompetition;
import com.tommyrot.papelcesto.usecase.CrudCompetition;

@RestController
@RequestMapping(value = "competitions")
public class CompetitionController {

	
	private final CrudCompetition competitionCrud;

	@Autowired
	public CompetitionController(CrudCompetition competitionCrud) {
		super();
		this.competitionCrud = competitionCrud;
	}
	
	@RequestMapping(value="{id:\\d+}", method = RequestMethod.GET)
	public Competition getCompetitionById(@PathVariable("id") Integer id){
		return competitionCrud.getCompetitionById(id);
		
	}
	@RequestMapping(method = RequestMethod.GET)
	public List<Competition> getAllCompetitions(){
		return competitionCrud.getCompetitions();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Competition> createCompetition(@RequestBody CreateCompetition competitionToCreate){
		return new ResponseEntity<Competition>(competitionCrud.createNewCompetition(competitionToCreate),HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Competition updateCompetition(@RequestBody UpdateCompetition competitionToUpdate){
		return competitionCrud.updateCompetition(competitionToUpdate);
		
	}
	@RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
	public void deleteCompetition(@PathVariable("id") Integer id){
		competitionCrud.deleteCompetition(id);
	}
	
}
