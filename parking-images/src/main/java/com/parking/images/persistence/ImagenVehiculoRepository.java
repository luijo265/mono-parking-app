package com.parking.images.persistence;

import com.parking.images.domain.ImageVehicule;
import com.parking.images.domain.repository.ImageVehiculeRepository;
import com.parking.images.persistence.crud.ImagenVehiculoMongoRepository;
import com.parking.images.persistence.entity.ImagenVehiculo;
import com.parking.images.persistence.mapper.ImageVehiculeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImagenVehiculoRepository implements ImageVehiculeRepository {

    @Autowired
    private ImagenVehiculoMongoRepository imagenVehiculoMongoRepository;

    @Autowired
    private ImageVehiculeMapper mapper;

    public List<ImageVehicule> getImageVehicules(){
        return mapper.toImageVehicules(imagenVehiculoMongoRepository.findAll());
    }

    @Override
    public void saveImageVehicule(String base64) throws Exception {
        ImagenVehiculo vehiculo = ImagenVehiculo.builder()
                .base64(base64)
                .build();
        imagenVehiculoMongoRepository.save(vehiculo);
    }

    @Override
    public Optional<ImageVehicule> getImageVehicule(String id) throws Exception {
        Optional<ImagenVehiculo> vehiculo = imagenVehiculoMongoRepository.findById(id);
        if (vehiculo.isPresent())
            return vehiculo.map(mapper::toImageVehicule);
        else
            return Optional.empty();
    }
}
