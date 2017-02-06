package com.tommyrot.papelcesto.dto.update;

import lombok.Data;

@Data
public class UpdateCompetition {

	private Integer id;
	private String competitionName;
	private boolean active;
	
}
