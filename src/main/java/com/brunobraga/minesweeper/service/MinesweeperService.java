package com.brunobraga.minesweeper.service;

import com.brunobraga.minesweeper.dto.GamePlayInputDTO;
import com.brunobraga.minesweeper.dto.GamePlayResponseDTO;

public interface MinesweeperService {

    GamePlayResponseDTO createGame(GamePlayInputDTO gamePlayInputDTO);
}
