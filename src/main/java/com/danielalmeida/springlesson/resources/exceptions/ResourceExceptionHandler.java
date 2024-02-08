package com.danielalmeida.springlesson.resources.exceptions;

import com.danielalmeida.springlesson.services.exceptions.DatabaseException;
import com.danielalmeida.springlesson.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // error interceptor
public class ResourceExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class) // error of "Not Found Exception" type
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException errorMsg, HttpServletRequest request){
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, errorMsg.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
  @ExceptionHandler(DatabaseException.class) // error of "Not Found Exception" type
  public ResponseEntity<StandardError> database(DatabaseException errorMsg, HttpServletRequest request){
    String error = "Database error";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    StandardError err = new StandardError(Instant.now(), status.value(), error, errorMsg.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }
}
