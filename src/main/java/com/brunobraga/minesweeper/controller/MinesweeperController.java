package com.brunobraga.minesweeper.controller;

import com.brunobraga.minesweeper.dto.GamePlayInputDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MinesweeperController {

  @GetMapping
  ResponseEntity<?> getGame(@RequestParam String idGame);

  @PostMapping
  @ApiOperation(value = "Create a new Game with body values")
  ResponseEntity<?> createGame(@RequestBody GamePlayInputDTO gamePlayInputDTO) throws Exception;
}
