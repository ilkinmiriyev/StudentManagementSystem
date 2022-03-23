package edu.deegrework.StudentManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({RecordNotFoundException.class, RequiredFieldException.class})
    public ResponseEntity<ExceptionResponse> resourceNotFoundException(RuntimeException runtimeException,
                                                                      WebRequest webRequest) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(runtimeException.getMessage())
                .exceptionClassName(runtimeException.getClass().getName())
                .localDateTime(LocalDateTime.now())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }





    /*@ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponse> runtimeException(RuntimeException runtimeException,
                                                              WebRequest webRequest) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .exceptionClassName(runtimeException.getClass().getName())
                .localDateTime(LocalDateTime.now())
                .message(runtimeException.getMessage())
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
}
