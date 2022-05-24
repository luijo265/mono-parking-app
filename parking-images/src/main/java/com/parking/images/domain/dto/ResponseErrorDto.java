package com.parking.images.domain.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseErrorDto {
    String userMessage;
    String developMessage;
}
