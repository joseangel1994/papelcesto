package com.tommyrot.papelcesto.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.domain.PerformanceEntity;
import com.tommyrot.papelcesto.dto.Performance;
import com.tommyrot.papelcesto.dto.create.CreatePerformance;
import com.tommyrot.papelcesto.mappers.performance.CreatePerformanceToPerformanceMapper;
import com.tommyrot.papelcesto.mappers.performance.PerformanceEntityToPerformanceMapper;
import com.tommyrot.papelcesto.mappers.performance.PerformanceToPerformanceEntityMapper;
import com.tommyrot.papelcesto.repositories.PerformanceRepository;
import com.tommyrot.papelcesto.repositories.PlayerRepository;

@Service
public class CrudPerformance {
	
	private PerformanceRepository repository;
	private PlayerRepository playerRepository;
	
	private PerformanceEntityToPerformanceMapper performanceEntityToPerformanceMapper;
	private PerformanceToPerformanceEntityMapper performanceToPerformanceEntityMapper;
	private CreatePerformanceToPerformanceMapper createPerformanceToPerformanceMapper;
	
	@Autowired
	public CrudPerformance(PerformanceRepository repository, PlayerRepository playerRepository,
			PerformanceEntityToPerformanceMapper performanceEntityToPerformanceMapper,
			PerformanceToPerformanceEntityMapper performanceToPerformanceEntityMapper,
			CreatePerformanceToPerformanceMapper createPerformanceToPerformanceMapper) {
		super();
		this.repository = repository;
		this.playerRepository = playerRepository;
		this.performanceEntityToPerformanceMapper = performanceEntityToPerformanceMapper;
		this.performanceToPerformanceEntityMapper = performanceToPerformanceEntityMapper;
		this.createPerformanceToPerformanceMapper = createPerformanceToPerformanceMapper;
	}	

	public List<Performance> getPerformancesByPlayer(Integer playerId){
		return repository.findByPlayer(playerRepository.findOne(playerId))//
				.stream()//
				.map(performanceEntity -> performanceEntityToPerformanceMapper.map(performanceEntity))//
				.collect(Collectors.toList());
	}

	public List<Performance> getPerformances(){
		return repository.findAll()//
				.stream()//
				.map(performanceEntity -> performanceEntityToPerformanceMapper.map(performanceEntity))//
				.collect(Collectors.toList());
	}
	
	public Performance createPerformance(CreatePerformance performanceToCreate){
		PerformanceEntity newPerformanceEntity = new PerformanceEntity();
	   
		repository.save(newPerformanceEntity);

	    return createPerformanceToPerformanceMapper.map(performanceToCreate);
	}
	
	public Performance updatePerformance(Integer id, Performance performanceToUpdate){
		PerformanceEntity newPerformanceEntity = repository.findOne(id);
	    newPerformanceEntity.setScore(performanceToUpdate.getScore());

	    repository.save(newPerformanceEntity);

	    return performanceToUpdate;
	}
	
	public void deletePerformance(Integer id){
		repository.delete(id);
	}

}
