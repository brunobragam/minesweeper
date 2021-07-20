package com.brunobraga.minesweeper.dto;

import com.brunobraga.minesweeper.domain.GamePlay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GamePlayResponseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String gameId;
  private String localDateTime;
  private int bombs;
  private int rows;
  private int columns;

  public static GamePlayResponseDTO entityToGamePlayResponseDTO(GamePlay entity) {
    ModelMapper mapper = new ModelMapper();
    return mapper.map(entity, GamePlayResponseDTO.class);
  }
}
