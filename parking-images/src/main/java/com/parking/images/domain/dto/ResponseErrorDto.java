package com.parking.images.domain.dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorDto implements Serializable {

    private static final long serialVersionUID = 4036906156713666282L;

    String userMessage;
    String developMessage;
}
