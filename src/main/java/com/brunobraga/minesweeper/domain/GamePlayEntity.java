package com.brunobraga.minesweeper.domain;

import com.brunobraga.minesweeper.exceptions.BusinessException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Getter
@Setter
@NoArgsConstructor
public class GamePlayEntity  implements Serializable {

  private static final long serialVersionUID = 1L;

  private String gameId;
  private LocalDateTime localDateTime;
  private int bombs;
  private int rows;
  private int columns;

  public GamePlayEntity(int bombs, int rows, int columns) {


    this.gameId = UUID.randomUUID().toString();
    this.localDateTime = LocalDateTime.now();
    this.bombs = bombs;
    this.rows = rows;
    this.columns = columns;

    validateMinimalGameConfiguration(this.bombs, this.rows, this.columns);
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
    int numberOfBoardPositions = this.columns * this.rows;

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
