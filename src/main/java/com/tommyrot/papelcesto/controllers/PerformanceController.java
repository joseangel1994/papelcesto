package com.tommyrot.papelcesto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tommyrot.papelcesto.dto.Performance;
import com.tommyrot.papelcesto.usecase.CrudPerformance;

@RestController
@RequestMapping(value = "/player/{id}/performances")
public class PerformanceController {
	
	private final CrudPerformance crudPerformance;

	@Autowired
	public PerformanceController(CrudPerformance crudPerformance) {
		super();
		this.crudPerformance = crudPerformance;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Performance> getPerformancesByPlayerId(@PathVariable("playerId") Integer playerId){
		return crudPerformance.getPerformancesByPlayer(playerId);
	}
	
//	public Performance createPerformance(CreatePerformance performanceToCreate){
//		return crudPerformance.createPerformance(performanceToCreate);
//	}
//	
//	public Performance updatePerformance(Integer id, Performance performanceToUpdate){
//		return crudPerformance.updatePerformance(id, performanceToUpdate);
//	}
//
//	public void deletePerformance(Integer id){
//		crudPerformance.deletePerformance(id);
//	}
	
}
