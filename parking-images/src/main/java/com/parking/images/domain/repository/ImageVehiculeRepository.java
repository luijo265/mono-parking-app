package com.parking.images.domain.repository;

import com.parking.images.domain.ImageVehicule;

import java.util.List;

public interface ImageVehiculeRepository {

    public List<ImageVehicule> getImageVehicules();
    public void saveImageVehicule(String base64) throws Exception;

}
