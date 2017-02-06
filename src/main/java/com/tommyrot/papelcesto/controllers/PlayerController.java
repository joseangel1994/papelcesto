package com.tommyrot.papelcesto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
