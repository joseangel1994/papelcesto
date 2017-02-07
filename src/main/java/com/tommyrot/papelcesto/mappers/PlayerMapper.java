package com.tommyrot.papelcesto.mappers;

import org.springframework.stereotype.Component;

import com.tommyrot.papelcesto.domain.PlayerEntity;
import com.tommyrot.papelcesto.dto.Player;
import com.tommyrot.papelcesto.dto.create.CreatePlayer;
import com.tommyrot.papelcesto.dto.update.UpdatePlayer;

@Component
public class PlayerMapper {

  public PlayerEntity toPlayerEntity(CreatePlayer createPlayer) {
    PlayerEntity playerToCreate = new PlayerEntity();
    playerToCreate.setName(createPlayer.getName());
    playerToCreate.setPerformanceId(createPlayer.getPerformanceId());
    return playerToCreate;
  }

  public PlayerEntity updatePlayerEntity(UpdatePlayer updatePlayer, PlayerEntity playerToCreate) {
    playerToCreate.setPlayerId(updatePlayer.getPlayerId());
    playerToCreate.setName(updatePlayer.getName());
    playerToCreate.setPerformanceId(updatePlayer.getPerformanceId());
    return playerToCreate;
  }

  public Player toPlayer(PlayerEntity playerToReturn) {
    Player target = new Player();
    target.setPlayerId(playerToReturn.getPlayerId());
    target.setName(playerToReturn.getName());
    target.setPerformanceId(playerToReturn.getPerformanceId());
    return target;
  }
}
