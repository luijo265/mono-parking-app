package com.parking.images.domain.repository;

import com.parking.images.domain.ImageVehicule;

import java.util.List;
import java.util.Optional;

public interface ImageVehiculeRepository {

    public List<ImageVehicule> getImageVehicules();
    public void saveImageVehicule(String base64) throws Exception;
    public Optional<ImageVehicule> getImageVehicule(String id) throws Exception;

}
