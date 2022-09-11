package com.felipemoreira.bookstore.domain.exception;

import static java.time.LocalDateTime.now;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BookstoreExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        return buildResponseEntity(NOT_FOUND, exception.getMessage(),
            singletonList(exception.getMessage()));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception) {
        return buildResponseEntity(BAD_REQUEST, exception.getMessage(),
            singletonList(exception.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status,
        WebRequest request) {

        List<String> errors = new ArrayList<>();

        exception.getBindingResult().getFieldErrors()
            .forEach(fieldError -> errors.add("Field " + fieldError.getField().toUpperCase() + " "
                + fieldError.getDefaultMessage()));

        exception.getBindingResult().getGlobalErrors()
            .forEach(globalError -> errors.add("Object " + globalError.getObjectName().toUpperCase() + " "
                + globalError.getDefaultMessage()));

        return buildResponseEntity(BAD_REQUEST, "Informed argument(s) validation error(s)", errors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
        HttpMessageNotReadableException exception, HttpHeaders headers, HttpStatus status,
        WebRequest request) {
        return buildResponseEntity(BAD_REQUEST, "Malformed JSON body and/or field error",
            singletonList(exception.getLocalizedMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, String message,
        List<String> errors) {
        ApiError apiError = ApiError.builder()
            .code(httpStatus.value())
            .status(httpStatus.getReasonPhrase())
            .message(message)
            .errors(errors)
            .timestamp(now())
            .build();

        return ResponseEntity.status(httpStatus).body(apiError);
    }
}
