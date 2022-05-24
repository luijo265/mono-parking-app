package com.parking.images.domain.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter @Setter
@Builder
@AllArgsConstructor
public class ResponseRestDto <T> implements Serializable {

    private static final long serialVersionUID = 1607171266212205238L;
    int status;
    T data;
    ResponseErrorDto error;

}

