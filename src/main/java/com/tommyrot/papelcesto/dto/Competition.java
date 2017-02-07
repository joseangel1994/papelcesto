package com.tommyrot.papelcesto.dto;

import java.util.List;

import lombok.Data;

@Data
public class Competition {

	private Integer id;
	private String competitionName;
	private boolean active;
	private List<Match> matches;
}
