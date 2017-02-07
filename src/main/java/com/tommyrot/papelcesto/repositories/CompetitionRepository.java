package com.tommyrot.papelcesto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommyrot.papelcesto.domain.CompetitionEntity;

public interface CompetitionRepository extends JpaRepository<CompetitionEntity, Integer>{

	public CompetitionEntity findCompetitionById(Integer id);

}
