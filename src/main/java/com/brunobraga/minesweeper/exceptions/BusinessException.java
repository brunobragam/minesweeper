package com.brunobraga.minesweeper.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BusinessException extends RuntimeException {

  private String label;
  private String message;
  private HttpStatus httpStatus;
}
