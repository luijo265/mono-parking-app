package com.parking.images.domain.dto;

import lombok.*;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ImageVehiculeDto {

    private String imageId;
    private String file;
    private Map<String, String> features;

}
