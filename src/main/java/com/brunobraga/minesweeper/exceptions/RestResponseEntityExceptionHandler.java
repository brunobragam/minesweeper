package com.brunobraga.minesweeper.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ServiceException.class})
  public ResponseEntity<?> handleGenericException(ServiceException genericException) {

    var responseBody =
        ApiErrorContract.builder()
            .label(genericException.getLabel())
            .message(genericException.getMessage())
            .build();

    Optional.ofNullable(genericException.getCause())
        .ifPresent(error -> log.error(error.toString()));

    return new ResponseEntity<>(responseBody, new HttpHeaders(), genericException.getHttpStatus());
  }
}
