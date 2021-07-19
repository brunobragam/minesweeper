package com.brunobraga.minesweeper.service;

import com.brunobraga.minesweeper.component.NewGameComponent;
import com.brunobraga.minesweeper.domain.GamePlay;
import com.brunobraga.minesweeper.dto.GamePlayInputDTO;
import com.brunobraga.minesweeper.dto.GamePlayResponseDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.brunobraga.minesweeper.dto.GamePlayResponseDTO.entityToGamePlayResponseDTO;

@Slf4j
@Service
@AllArgsConstructor
public class MinesweeperServiceImpl implements MinesweeperService {

  public final NewGameComponent newGameComponent;

  @Override
  public GamePlayResponseDTO createGame(GamePlayInputDTO gamePlayInputDTO) {
    var gamePlayEntity =
        new GamePlay(
            gamePlayInputDTO.getBombs(), gamePlayInputDTO.getRows(), gamePlayInputDTO.getColumns());

    GamePlay gamePlayBoardConstructed = newGameComponent.execute(gamePlayEntity);

    log.debug(gamePlayBoardConstructed.getBoardGame().toString());
    return entityToGamePlayResponseDTO(gamePlayEntity);
  }
}
