package com.parking.images.domain.service;

import com.parking.images.domain.ImageVehicule;
import com.parking.images.domain.dto.ImageVehiculeDto;
import com.parking.images.domain.dto.ResponseRestDto;

import java.util.List;

public interface ImageVehiculeService {

    List<ImageVehicule> getImageVehicules();
    ResponseRestDto<ImageVehiculeDto> getImageVehicule(String imageId) throws Exception;
    ResponseRestDto<Object> saveImageVehicule(String file) throws Exception;


}
