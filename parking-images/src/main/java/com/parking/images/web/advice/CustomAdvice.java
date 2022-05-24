package com.parking.images.web.advice;

import com.parking.images.domain.dto.ResponseErrorDto;
import com.parking.images.domain.dto.ResponseRestDto;
import com.parking.images.web.exception.DevelopUserException;
import com.parking.images.web.exception.ElementoNoEncontradoException;
import com.parking.images.web.exception.ValidacionException;
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
                        .status(HttpStatus.BAD_REQUEST.value())
                        .error(ResponseErrorDto.builder()
                                .developMessage(ex.getMessage())
                                .userMessage("Error en los campos enviados")
                                .build())
                        .build());
    }

    @ExceptionHandler({
            ValidacionException.class,
            ElementoNoEncontradoException.class
    })
    public ResponseEntity<ResponseRestDto> handleValidacionException(DevelopUserException ex, WebRequest request){
        return ResponseEntity.status(ex.getStatus())
                .body(ResponseRestDto.builder()
                        .status(ex.getStatus().value())
                        .error(ResponseErrorDto.builder()
                                .developMessage(ex.getDevelopMessage())
                                .userMessage(ex.getUserMessage())
                                .build())
                        .build());
    }

}
