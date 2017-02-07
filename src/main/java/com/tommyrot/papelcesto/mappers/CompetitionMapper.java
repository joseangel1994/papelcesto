package com.tommyrot.papelcesto.mappers;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.domain.CompetitionEntity;
import com.tommyrot.papelcesto.dto.Competition;
import com.tommyrot.papelcesto.dto.create.CreateCompetition;
import com.tommyrot.papelcesto.dto.update.UpdateCompetition;


@Component
public class CompetitionMapper {

  public Competition toCompetition(CompetitionEntity competitionEntity) {

    Competition result = new Competition();
    result.setId(competitionEntity.getId());
    result.setCompetitionName(competitionEntity.getCompetitionName());
    result.setActive(competitionEntity.isActive());

    return result;
  }

  public CompetitionEntity toCompetitionEntity(CreateCompetition competitionToCreate) {

    CompetitionEntity result = new CompetitionEntity();
    result.setActive(competitionToCreate.isActive());
    result.setCompetitionName(competitionToCreate.getCompetitionName());

    return result;
  }

  public CompetitionEntity updateCompetitionEntity(UpdateCompetition competitionToUpdate,
      CompetitionEntity entityToUpdate) {

    entityToUpdate.setActive(competitionToUpdate.isActive());
    entityToUpdate.setCompetitionName(competitionToUpdate.getCompetitionName());

    return entityToUpdate;
  }


}
