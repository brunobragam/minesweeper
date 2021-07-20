package com.brunobraga.minesweeper.domain;

import com.brunobraga.minesweeper.exceptions.BusinessException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Getter
@Setter
@NoArgsConstructor
public class GamePlay implements Serializable {

  private static final long serialVersionUID = 1L;

  private String gameId;
  private String localDateTime;
  private int userInputedBombs;
  private int userInputedRows;
  private int userInputedColumns;

  private HashMap<FieldPositionKey, FieldPositionDetail> boardGame = new HashMap<>();

  public GamePlay(int bombs, int rows, int columns) {

    this.gameId = UUID.randomUUID().toString();
    this.localDateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    this.userInputedBombs = bombs;
    this.userInputedRows = rows;
    this.userInputedColumns = columns;

    validateMinimalGameConfiguration(
        this.userInputedBombs, this.userInputedRows, this.userInputedColumns);
  }

  private void validateMinimalGameConfiguration(int bombs, int rows, int columns) {
    validateNumberOfBoardSize(columns, rows);
    validateNumberOfBombsToBoard(bombs);
  }

  private void validateNumberOfBoardSize(int rows, int columns) {
    if (rows <= 2 || columns <= 2) {
      throw new BusinessException(
          "label.error", "Minimal values not allowed!", UNPROCESSABLE_ENTITY);
    }
  }

  private void validateNumberOfBombsToBoard(int bombs) {
    int numberOfBoardPositions = this.userInputedColumns * this.userInputedRows;

    if (bombs > numberOfBoardPositions) {
      throw new BusinessException(
          "label.error",
          format(
              "Number of bombs was exceeded for this board! Maximun is: %s",
              numberOfBoardPositions),
          UNPROCESSABLE_ENTITY);
    }
  }
}
