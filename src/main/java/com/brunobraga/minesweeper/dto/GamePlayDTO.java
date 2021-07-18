package com.brunobraga.minesweeper.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GamePlayDTO {

    private int bombs;
    private int rows;
    private int columns;
}
