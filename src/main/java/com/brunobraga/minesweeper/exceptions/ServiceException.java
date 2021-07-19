package com.brunobraga.minesweeper.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ServiceException extends Exception {

  private String label;
  private String message;
  private HttpStatus httpStatus;
  private Throwable cause;

  public ServiceException(String label, String message, HttpStatus httpStatus) {
    this.label = label;
    this.message = message;
    this.httpStatus = httpStatus;
  }
}
