package com.magadh.farm.common.exceptions;

import com.magadh.farm.common.dto.ErrorDetail;
import com.magadh.farm.common.dto.ErrorResponse;
import com.magadh.farm.common.dto.ValidationErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles all the validation error
     * @param exception - MethodArgumentNotValidationException
     * @return Response Entity containing {@link ValidationErrorResponse}
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {
        List<ErrorDetail> errors = new ArrayList<>();
        exception.getBindingResult().getAllErrors().forEach( error -> {
                String fieldName = ((FieldError)error).getField();
                String errorMessage = ((FieldError)error).getDefaultMessage();
                ErrorDetail errorDetail = new ErrorDetail(fieldName, errorMessage);
                errors.add(errorDetail);
            }
        );
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse(HttpStatus.BAD_REQUEST.value(),errors);
        return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(HttpMessageNotReadableException exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Problem with request input data");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        LOGGER.error("Exception: {}, Request Details: {}", exception.getMessage(), request.getDescription(false), exception);
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException exception, WebRequest request) {
        LOGGER.error("Exception: {}, Request Details: {}", exception.getMessage(), request.getDescription(false), exception);
        ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error occurred");
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
