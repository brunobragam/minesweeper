package com.brunobraga.minesweeper.controller;

import com.brunobraga.minesweeper.dto.GamePlayInputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface MinesweeperController {

    //TODO Implement Swagger documentation

    @GetMapping
    ResponseEntity<?> getGame(@RequestParam String idGame);

    @PostMapping
    ResponseEntity<?> createGame(@RequestBody GamePlayInputDTO gamePlayInputDTO) throws Exception;
}
