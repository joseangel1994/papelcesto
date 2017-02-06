package com.tommyrot.papelcesto.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.domain.PlayerEntity;
import com.tommyrot.papelcesto.dto.Player;
import com.tommyrot.papelcesto.mappers.PlayerMapper;
import com.tommyrot.papelcesto.repositories.PlayerRepository;

@Service
public class CrudPlayerUsercase {

  private final PlayerRepository playerRepository;
  private final PlayerMapper playerMapper;

  @Autowired
  public CrudPlayerUsercase(PlayerRepository playerRepository, PlayerMapper playerMapper) {
    super();
    this.playerRepository = playerRepository;
    this.playerMapper = playerMapper;
  }


  public Player findById(long playerId) {
    PlayerEntity playerToCreate = playerRepository.findPlayerById(playerId);
    Player playerToReturn = playerMapper.toPlayer(playerToCreate);
    return playerToReturn;
  }


}
