package com.tommyrot.papelcesto.usecase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
///import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.domain.CompetitionEntity;
import com.tommyrot.papelcesto.dto.Competition;
import com.tommyrot.papelcesto.dto.create.CreateCompetition;
import com.tommyrot.papelcesto.dto.update.UpdateCompetition;
import com.tommyrot.papelcesto.mappers.CompetitionMapper;
import com.tommyrot.papelcesto.repositories.CompetitionRepository;

@Service
public class CrudCompetition {
	
	private final CompetitionRepository competitionrepository;
	private final CompetitionMapper competitionMapper;

	
	@Autowired
	public CrudCompetition(CompetitionRepository competitionrepository, CompetitionMapper competitionMapper) {
		super();
		this.competitionrepository = competitionrepository;
		this.competitionMapper = competitionMapper;
	}



	public List<Competition> getCompetitions(){
		List<CompetitionEntity> source = competitionrepository.findAll();
		List<Competition> result = new LinkedList<>();
		
		for (CompetitionEntity iterator : source) {
			result.add(competitionMapper.toCompetition(iterator));
		}
		
		return result;
		
	}
	
	public Competition getCompetitionById(Integer id){
		
		return competitionMapper.toCompetition(competitionrepository.getOne(id));
	}
	
	public Competition createNewCompetition(CreateCompetition createCompetition){
		
		CompetitionEntity competitionToCreate = competitionMapper.toCompetitionEntity(createCompetition);
		competitionrepository.save(competitionToCreate);
		
		return competitionMapper.toCompetition(competitionToCreate);
	}
	
	public Competition updateCompetition(Integer id, UpdateCompetition updateCompetition){
		
		CompetitionEntity entityToUpdate = competitionrepository.findOne(id);
		CompetitionEntity updatedEntity = competitionMapper.updateCompetitionEntity(updateCompetition, entityToUpdate);
		
		competitionrepository.save(updatedEntity);
		
		return competitionMapper.toCompetition(updatedEntity);
		
	}
	
	public void deleteCompetition(Integer id){
		competitionrepository.delete(id);
	}
	
}
