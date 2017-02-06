package com.tommyrot.papelcesto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommyrot.papelcesto.domain.MatchEntity;

public interface MatchRepositoy extends JpaRepository<MatchEntity, Integer> {

}
