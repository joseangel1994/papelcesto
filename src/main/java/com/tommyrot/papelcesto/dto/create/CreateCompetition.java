package com.tommyrot.papelcesto.dto.create;

import java.util.List;

import com.tommyrot.papelcesto.domain.MatchEntity;

public class CreateCompetition {

	private String competitionName;
	private boolean active;
	private List<MatchEntity> matches;
}
