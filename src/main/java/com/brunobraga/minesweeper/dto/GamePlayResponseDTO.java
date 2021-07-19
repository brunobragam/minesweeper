package com.brunobraga.minesweeper.dto;

import com.brunobraga.minesweeper.domain.GamePlayEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GamePlayResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String gameId;
  private LocalDateTime localDateTime;
  private int bombs;
  private int rows;
  private int columns;

  public static GamePlayResponseDTO entityToGamePlayResponseDTO(GamePlayEntity entity) {
    var mapper = new ModelMapper();
    return mapper.map(entity, GamePlayResponseDTO.class);
  }
}
