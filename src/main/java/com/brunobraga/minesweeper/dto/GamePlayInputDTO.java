package com.brunobraga.minesweeper.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayInputDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int bombs;
  private int rows;
  private int columns;
}
