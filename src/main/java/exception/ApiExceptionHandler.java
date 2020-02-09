package exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import exception.model.ExceptionMessages;
import exception.model.ExceptionModel;
import exception.model.custom.CookieException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAnyExceptions(Exception ex) {
        return buildExceptionEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR, ExceptionMessages.DEFAULT.getExMsg());
    }

    @ExceptionHandler(CookieException.class)
    public ResponseEntity<?> handleCookieException(CookieException ex) {
        return buildExceptionEntity(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    private ResponseEntity<?> buildExceptionEntity(Exception ex, HttpStatus status, String message) {
        ex.printStackTrace();
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setException(ex.getClass().getSimpleName());
        exceptionModel.setReason(message);
        return new ResponseEntity<>(exceptionModel, status);
    }
}