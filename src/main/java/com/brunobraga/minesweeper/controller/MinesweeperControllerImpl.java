package com.brunobraga.minesweeper.controller;

import com.brunobraga.minesweeper.dto.GamePlayInputDTO;
import com.brunobraga.minesweeper.dto.GamePlayResponseDTO;
import com.brunobraga.minesweeper.exceptions.BusinessException;
import com.brunobraga.minesweeper.exceptions.ServiceException;
import com.brunobraga.minesweeper.service.MinesweeperService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/game")
public class MinesweeperControllerImpl implements MinesweeperController {

  private final MinesweeperService minesweeperService;

  @Override
  public ResponseEntity<?> getGame(String idGame) {
    return null;
  }

  @Override
  public ResponseEntity<GamePlayResponseDTO> createGame(GamePlayInputDTO gamePlayInputDTO) throws Exception {
    try {
      var response = minesweeperService.createGame(gamePlayInputDTO);
      return ResponseEntity.ok().body(response);

    } catch (BusinessException businessException) {

      throw new ServiceException(
          businessException.getLabel(),
          businessException.getMessage(),
          businessException.getHttpStatus());
    }

  }
}
