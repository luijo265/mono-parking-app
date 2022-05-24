package com.parking.images.persistence.crud;

import com.parking.images.persistence.entity.ImagenVehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenVehiculoMongoRepository
    extends MongoRepository<ImagenVehiculo, String> {
}
