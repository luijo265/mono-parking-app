package com.parking.images.persistence.mapper;


import com.parking.images.domain.ImageVehicule;
import com.parking.images.persistence.entity.ImagenVehiculo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageVehiculeMapper {
    @Mappings({
            @Mapping(source = "id", target = "imageId"),
            @Mapping(source = "base64", target = "file")
    })
    ImageVehicule toImageVehicule(ImagenVehiculo imagenVehiculo);
    List<ImageVehicule> toImageVehicules(List<ImagenVehiculo> imagenVehiculos);

    @InheritInverseConfiguration
    ImagenVehiculo toImagenVehiculo(ImageVehicule imageVehicule);
}
