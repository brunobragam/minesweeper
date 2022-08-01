package com.brunobraga.minesweeper.enums.strategy;

import com.brunobraga.minesweeper.component.NewGameComponent;
import com.brunobraga.minesweeper.domain.FieldPositionDetail;
import com.brunobraga.minesweeper.enums.PositionEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

@Getter
@RequiredArgsConstructor
public enum PositionStrategy {//FieldYloc
  LEFT_TOP(PositionEnum.LEFT_TOP, NewGameComponent::verifyLeftTop),
  MIDDLE_TOP(PositionEnum.MIDDLE_TOP, NewGameComponent::verifyMiddleTop),
  RIGHT_TOP(PositionEnum.RIGHT_TOP, NewGameComponent::verifyRightTop),

  LEFT_MIDDLE(PositionEnum.LEFT_MIDDLE, NewGameComponent::verifyLeftMid),
  RIGHT_MIDDLE(PositionEnum.RIGHT_MIDDLE, NewGameComponent::verifyRightMid),

  LEFT_BOTTOM(PositionEnum.LEFT_BOTTOM, NewGameComponent::verifyLeftBottom),
  MIDDLE_BOTTOM(PositionEnum.MIDDLE_BOTTOM, NewGameComponent::verifyMidBottom),
  RIGHT_BOTTOM(PositionEnum.RIGHT_BOTTOM, NewGameComponent::verifyRightBottom);

  private final PositionEnum positionEnum;

  public final BiConsumer<NewGameComponent, FieldPositionDetail> hasAdjacentBomb;

  private static final Map<PositionEnum, PositionStrategy> mapSeguroStrategy = new HashMap<>();

  static {
    for (PositionStrategy seguroStrategy : PositionStrategy.values()) {
      mapSeguroStrategy.put(seguroStrategy.positionEnum, seguroStrategy);
    }
  }

  public static PositionStrategy selectGeoReferenceBoard(PositionEnum tipoProdutoEnum) {
    return mapSeguroStrategy.get(tipoProdutoEnum);
  }
}
