package edu.deegrework.StudentManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse resourceNotFoundException(RuntimeException runtimeException) {
        return new ExceptionResponse(runtimeException.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getFieldErrors().forEach(fieldError -> {
            String field = fieldError.getField();
            String error = fieldError.getDefaultMessage();
            errors.put(field, error);
        });
        return errors;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ExceptionResponse> handleConstraintException(ConstraintViolationException e){
        List<ExceptionResponse> errors = new ArrayList<>();
        e.getConstraintViolations()
                .forEach(ex-> errors.add(new ExceptionResponse(ex.getMessage())));
        return errors;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleEmailExist(IllegalStateException e){
        return new ExceptionResponse(e.getMessage());
    }
}
