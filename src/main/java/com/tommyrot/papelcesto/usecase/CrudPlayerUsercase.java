package com.tommyrot.papelcesto.usecase;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tommyrot.papelcesto.domain.PlayerEntity;
import com.tommyrot.papelcesto.dto.Player;
import com.tommyrot.papelcesto.dto.create.CreatePlayer;
import com.tommyrot.papelcesto.dto.update.UpdatePlayer;
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


  public Player findById(Integer playerId) {
    PlayerEntity playerToCreate = playerRepository.findOne(playerId);
    Player playerToReturn = playerMapper.toPlayer(playerToCreate);
    return playerToReturn;
  }

  public Player createNewPlayer(CreatePlayer createPlayer) {

    PlayerEntity playerToCreate = playerMapper.toPlayerEntity(createPlayer);
    playerRepository.save(playerToCreate);

    return playerMapper.toPlayer(playerToCreate);
  }

  public Player updatePlayer(UpdatePlayer updatePlayer, Integer playerId) {

    PlayerEntity playerToUpdate = playerRepository.findOne(playerId);
    playerMapper.updatePlayerEntity(updatePlayer, playerToUpdate);
    playerRepository.save(playerToUpdate);

    return playerMapper.toPlayer(playerToUpdate);
  }

  public List<Player> findAll() {
    List<PlayerEntity> playerList = playerRepository.findAll();
    List<Player> listToReturn = new LinkedList<>();
    for (PlayerEntity player : playerList) {
      listToReturn.add(playerMapper.toPlayer(player));
    }
    return listToReturn;
  }

  public List<Player> findByNameFilter(String filter) {

    List<PlayerEntity> findByNameContains = playerRepository.findByNameContains(filter);
    List<Player> listToReturn = new LinkedList<>();
    for (PlayerEntity player : findByNameContains) {
      listToReturn.add(playerMapper.toPlayer(player));
    }
    return listToReturn;
  }

  public void delete(Integer playerId) {
    playerRepository.delete(playerId);
  }
}
