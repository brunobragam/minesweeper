package com.brunobraga.minesweeper.component;

import com.brunobraga.minesweeper.domain.FieldPositionKey;
import com.brunobraga.minesweeper.domain.GamePlay;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NewGameComponent {

  public GamePlay execute(GamePlay gamePlay) {

    var random = new Random();
    var maxColumns = gamePlay.getUserInputedColumns();
    var maxRows = gamePlay.getUserInputedRows();
    var bombs = gamePlay.getUserInputedBombs();
    var bombsCreated = 0;

    for (int iCol = 1; iCol <= maxColumns; iCol++) {
      for (int iRow = 1; iRow <= maxRows; iRow++) {
        var putBomb = 0;
        if (bombs >= bombsCreated) {
          putBomb = random.nextInt(2);
          bombsCreated = bombsCreated + putBomb;
        }
        var key = new FieldPositionKey(iCol, iRow);
        gamePlay.getBoardGame().put(key, putBomb == 1);
      }
    }

    return gamePlay;
  }
}
