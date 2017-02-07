package com.tommyrot.papelcesto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommyrot.papelcesto.domain.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {

  PlayerEntity findPlayerById(Integer playerId);

  List<PlayerEntity> findByNameContains(String filter);

}
