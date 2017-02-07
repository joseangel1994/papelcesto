package com.tommyrot.papelcesto.mappers;

//import java.util.stream.Collector;
//import java.util.stream.Collectors;

import com.tommyrot.papelcesto.domain.CompetitionEntity;
import com.tommyrot.papelcesto.dto.Competition;
import com.tommyrot.papelcesto.dto.create.CreateCompetition;
import com.tommyrot.papelcesto.dto.update.UpdateCompetition;

//import scala.annotation.meta.setter;

public class CompetitionMapper {

	public Competition toCompetition(CompetitionEntity competitionEntity){
		
		Competition result = new Competition();
		result.setId(competitionEntity.getId());
		result.setCompetitionName(competitionEntity.getCompetitionName());
		result.setActive(competitionEntity.isActive());
		//result.setMatches(competitionEntity.getMatches().stream().map(match -> match).collect(Collectors.toList());
		
		return result;
	}
	
	public CompetitionEntity toCompetitionEntity(CreateCompetition competitionToCreate){
		
		CompetitionEntity result = new CompetitionEntity();
		result.setActive(competitionToCreate.isActive());
		result.setCompetitionName(competitionToCreate.getCompetitionName());
		
		return result;
	}
	
	public CompetitionEntity updateCompetitionEntity(UpdateCompetition competitionToUpdate, CompetitionEntity entityToUpdate){
		
		entityToUpdate.setActive(competitionToUpdate.isActive());
		entityToUpdate.setCompetitionName(competitionToUpdate.getCompetitionName());
		entityToUpdate.setId(competitionToUpdate.getId());
		//result.setMatches(matches);
		
		return entityToUpdate;
	}
	
	
}
