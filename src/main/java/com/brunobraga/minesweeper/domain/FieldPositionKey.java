package com.brunobraga.minesweeper.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/** Here has a exactly point of the field the game. */
@Getter
@Setter
@Builder
@NoArgsConstructor
public class FieldPositionKey implements Serializable {

  private static final long serialVersionUID = 1L;

  private int columnPoint;
  private int rowPoint;

  public FieldPositionKey(int columnPoint, int rowPoint) {
    this.columnPoint = columnPoint;
    this.rowPoint = rowPoint;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FieldPositionKey that = (FieldPositionKey) o;
    return columnPoint == that.columnPoint && rowPoint == that.rowPoint;
  }

  @Override
  public int hashCode() {
    return Objects.hash(columnPoint, rowPoint);
  }
}
