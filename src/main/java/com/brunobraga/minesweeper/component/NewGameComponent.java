package com.brunobraga.minesweeper.component;

import com.brunobraga.minesweeper.domain.FieldPositionDetail;
import com.brunobraga.minesweeper.domain.FieldPositionKey;
import com.brunobraga.minesweeper.domain.GamePlay;
import com.brunobraga.minesweeper.enums.strategy.PositionStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class NewGameComponent {

  private final BoardComponent boardComponent;
  private int totalAdjacentBombs;
  private int columnsBoard;
  private int rowsBoard;

  private HashMap<FieldPositionKey, FieldPositionDetail> boardGame;

  public GamePlay execute(GamePlay gamePlay) {
    boardGame = new HashMap<>();
    columnsBoard = gamePlay.getUserInputedColumns();
    rowsBoard = gamePlay.getUserInputedRows();

    boardComponent.buildRandomBoard(gamePlay);
    buildRandomBoard(gamePlay);

    boardGame = gamePlay.getBoardGame();

    adjacentPositionsBuild(boardGame);

    return gamePlay;
  }

  public void buildRandomBoard(GamePlay gamePlay) {
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
        var detailPosition =
            FieldPositionDetail.builder().fieldPositionKey(key).bomb(putBomb == 1).build();
        gamePlay.getBoardGame().put(key, detailPosition);
      }
    }
  }

  private void adjacentPositionsBuild(HashMap<FieldPositionKey, FieldPositionDetail> boardGame) {
    for (FieldPositionDetail positionBoard : boardGame.values()) {
      totalAdjacentBombs = 0;
      if (!positionBoard.isBomb()) {
        for (PositionStrategy geoReference : PositionStrategy.values()) {
          PositionStrategy.selectGeoReferenceBoard(geoReference.getPositionEnum())
              .getHasAdjacentBomb()
              .accept(this, positionBoard);
        }
      } else {
        totalAdjacentBombs = 1;
      }

      this.boardGame
          .get(positionBoard.getFieldPositionKey())
          .setTotalAdjacentBombs(totalAdjacentBombs);
    }
  }

  // top's

  public void verifyLeftTop(FieldPositionDetail fieldPositionDetail) {

    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceLT =
        FieldPositionKey.builder().rowPoint(rowPoint - 1).columnPoint(columnPoint - 1).build();

    if (rowPoint > 2 && columnPoint > 2) {
      if (boardGame.get(geoReferenceLT).isBomb()) totalAdjacentBombs++;
    }
  }

  public void verifyMiddleTop(FieldPositionDetail fieldPositionDetail) {

    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceTM =
        FieldPositionKey.builder().rowPoint(rowPoint - 1).columnPoint(columnPoint).build();

    if (rowPoint > 1) {
      if (boardGame.get(geoReferenceTM).isBomb()) totalAdjacentBombs++;
    }
  }

  public void verifyRightTop(FieldPositionDetail fieldPositionDetail) {
    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceRT =
        FieldPositionKey.builder().rowPoint(rowPoint - 1).columnPoint(columnPoint).build();

    if (rowPoint > 1 && columnPoint <= columnsBoard) {
      if (boardGame.get(geoReferenceRT).isBomb()) totalAdjacentBombs++;
    }
  }

  // midle's
  public void verifyLeftMid(FieldPositionDetail fieldPositionDetail) {
    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceRT =
        FieldPositionKey.builder().rowPoint(rowPoint).columnPoint(columnPoint - 1).build();

    if (columnPoint > 1) {
      if (boardGame.get(geoReferenceRT).isBomb()) totalAdjacentBombs++;
    }
  }

  public void verifyRightMid(FieldPositionDetail fieldPositionDetail) {
    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceRT =
        FieldPositionKey.builder().rowPoint(rowPoint).columnPoint(columnPoint + 1).build();

    if (columnPoint < columnsBoard) {
      if (boardGame.get(geoReferenceRT).isBomb()) totalAdjacentBombs++;
    }
  }

  // bottom's
  public void verifyLeftBottom(FieldPositionDetail fieldPositionDetail) {
    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceRT =
        FieldPositionKey.builder().rowPoint(rowPoint + 1).columnPoint(columnPoint - 1).build();

    if (columnPoint > 1 && rowPoint < rowsBoard) {
      if (boardGame.get(geoReferenceRT).isBomb()) totalAdjacentBombs++;
    }
  }

  public void verifyMidBottom(FieldPositionDetail fieldPositionDetail) {
    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceRT =
        FieldPositionKey.builder().rowPoint(rowPoint + 1).columnPoint(columnPoint).build();

    if (rowPoint < rowsBoard) {
      if (boardGame.get(geoReferenceRT).isBomb()) totalAdjacentBombs++;
    }
  }

  public void verifyRightBottom(FieldPositionDetail fieldPositionDetail) {
    var rowPoint = fieldPositionDetail.getFieldPositionKey().getRowPoint();
    var columnPoint = fieldPositionDetail.getFieldPositionKey().getColumnPoint();

    var geoReferenceRT =
        FieldPositionKey.builder().rowPoint(rowPoint + 1).columnPoint(columnPoint + 1).build();

    if (columnPoint < columnsBoard && rowPoint < rowsBoard) {
      if (boardGame.get(geoReferenceRT).isBomb()) totalAdjacentBombs++;
    }
  }
}
