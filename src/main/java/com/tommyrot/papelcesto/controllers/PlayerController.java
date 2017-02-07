package com.tommyrot.papelcesto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tommyrot.papelcesto.dto.Player;
import com.tommyrot.papelcesto.dto.create.CreatePlayer;
import com.tommyrot.papelcesto.dto.update.UpdatePlayer;
import com.tommyrot.papelcesto.usecase.CrudPlayerUsercase;


@RestController // Para resolver devolviendo un json (usado para las API REST)
@RequestMapping("players")
public class PlayerController {

  private final CrudPlayerUsercase crudPlayerUsercase;

  @Autowired
  public PlayerController(CrudPlayerUsercase crudPlayerUsercase) {
    super();
    this.crudPlayerUsercase = crudPlayerUsercase;
  }


  @RequestMapping(method = RequestMethod.GET)
  public List<Player> getPlayers(@RequestParam(value = "name", required = false) String name) {
    if (name == null) {
      return crudPlayerUsercase.findAll();
    } else {
      return crudPlayerUsercase.findByNameFilter(name);
    }
  }

  @RequestMapping(value = "{id:\\d+}", method = RequestMethod.GET)
  public Player getPlayerByName(@PathVariable("id") Integer playerId) {
    return crudPlayerUsercase.findById(playerId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Player createPlayer(@RequestBody CreatePlayer createPlayer) {
    return crudPlayerUsercase.createNewPlayer(createPlayer);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public Player editPlayer(@RequestBody UpdatePlayer updatePlayer) {
    return crudPlayerUsercase.updatePlayer(updatePlayer);
  }

  @RequestMapping(value = "{id:\\d+}", method = RequestMethod.DELETE)
  public void deletePlayer(@PathVariable("id") Integer playerId) {
    crudPlayerUsercase.delete(playerId);
  }

}
