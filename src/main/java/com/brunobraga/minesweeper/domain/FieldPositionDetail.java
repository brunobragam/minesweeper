package com.brunobraga.minesweeper.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FieldPositionDetail implements Serializable {

  private static final long serialVersionUID = 1L;

  private FieldPositionKey fieldPositionKey;
  private int totalAdjacentBombs;
  private boolean bomb;
}
