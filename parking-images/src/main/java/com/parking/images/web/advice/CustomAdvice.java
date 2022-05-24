package com.parking.images.web.advice;

import com.parking.images.domain.dto.ResponseErrorDto;
import com.parking.images.domain.dto.ResponseRestDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseRestDto.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .error(ResponseErrorDto.builder()
                                .developMessage(ex.getMessage())
                                .userMessage("Error en los campos enviados")
                                .build())
                        .build());
    }

}
