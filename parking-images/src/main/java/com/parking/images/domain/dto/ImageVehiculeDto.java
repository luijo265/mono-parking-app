package com.parking.images.domain.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class ImageVehiculeDto implements Serializable {

    private static final long serialVersionUID = 6665939840959764495L;
    private String imageId;
    private String file;
    private Map<String, String> features;

}
