package com.tommyrot.papelcesto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommyrot.papelcesto.domain.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
