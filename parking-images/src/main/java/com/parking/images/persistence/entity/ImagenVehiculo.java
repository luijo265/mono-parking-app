package com.parking.images.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "imagen_vehiculos")
public class ImagenVehiculo {

    @Id @Getter @Setter
    private String id;

    @Field("base64") @Getter @Setter
    private String base64;

}

