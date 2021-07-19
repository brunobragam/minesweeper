package com.brunobraga.minesweeper.service;

import com.brunobraga.minesweeper.domain.GamePlayEntity;
import com.brunobraga.minesweeper.dto.GamePlayInputDTO;
import com.brunobraga.minesweeper.dto.GamePlayResponseDTO;
import org.springframework.stereotype.Service;

import static com.brunobraga.minesweeper.dto.GamePlayResponseDTO.entityToGamePlayResponseDTO;

@Service
public class MinesweeperServiceImpl implements MinesweeperService {

  @Override
  public GamePlayResponseDTO createGame(GamePlayInputDTO gamePlayInputDTO) {
    var gamePlayEntity =
        new GamePlayEntity(
            gamePlayInputDTO.getBombs(), gamePlayInputDTO.getRows(), gamePlayInputDTO.getColumns());


    return entityToGamePlayResponseDTO(gamePlayEntity);
  }
}
