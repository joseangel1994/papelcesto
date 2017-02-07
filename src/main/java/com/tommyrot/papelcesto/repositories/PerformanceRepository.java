package com.tommyrot.papelcesto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommyrot.papelcesto.domain.PerformanceEntity;
import com.tommyrot.papelcesto.domain.PlayerEntity;
import java.util.List;

public interface PerformanceRepository extends JpaRepository<PerformanceEntity, Integer> {
	
	List<PerformanceEntity> findByPlayer(PlayerEntity player);

}
