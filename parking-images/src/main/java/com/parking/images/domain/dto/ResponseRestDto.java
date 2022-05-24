package com.parking.images.domain.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter @Setter
@Builder
@AllArgsConstructor
public class ResponseRestDto <T> {

    HttpStatus status;
    T data;
    ResponseErrorDto error;

}

