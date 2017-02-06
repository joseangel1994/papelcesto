package com.tommyrot.papelcesto.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.repositories.PlayerRepository;

@Service
public class CrudPlayerUsercase {

  private final PlayerRepository playerRepository;

  @Autowired
  public CrudPlayerUsercase(PlayerRepository playerRepository) {
    super();
    this.playerRepository = playerRepository;
  }



}
