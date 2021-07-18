package com.brunobraga.minesweeper.controller;

import com.brunobraga.minesweeper.dto.GamePlayDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/game")
public class MinesweeperControllerImpl implements MinesweeperController {

  @Override
  public ResponseEntity<?> getGame(String idGame) {
    return null;
  }

  @Override
  public ResponseEntity<?> createGame(GamePlayDTO gamePlayDTO) {
    return null;
  }
}
