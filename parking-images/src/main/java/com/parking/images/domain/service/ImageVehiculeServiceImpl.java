package com.parking.images.domain.service;

import com.parking.images.domain.ImageVehicule;
import com.parking.images.domain.dto.ImageVehiculeDto;
import com.parking.images.domain.dto.ResponseErrorDto;
import com.parking.images.domain.dto.ResponseRestDto;
import com.parking.images.domain.repository.ImageVehiculeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class ImageVehiculeServiceImpl implements ImageVehiculeService {

    private final Log LOGGER = LogFactory.getLog(ImageVehiculeServiceImpl.class);

    @Autowired
    private ImageVehiculeRepository imageVehiculeRepository;

    public List<ImageVehicule> getImageVehicules(){
        return imageVehiculeRepository.getImageVehicules();
    }

    @Override
    public ResponseRestDto<ImageVehiculeDto> getImageVehicule(String imageId) {
        return null;
    }

    @Override
    public ResponseRestDto<Object> saveImageVehicule(String file) throws Exception {
        try {

            isValueBase64(file);
            imageVehiculeRepository.saveImageVehicule(file);

            return ResponseRestDto.builder()
                    .status(HttpStatus.CREATED)
                    .build();

        } catch (Exception e){
            LOGGER.error("saveImageVehicule@message: "+ e.getMessage());
            LOGGER.error("saveImageVehicule@trace: ", e);
            throw new Exception(e.getMessage(), e);
        }
    }

    private void isValueBase64(String file) throws Exception {
        try {
            Base64.getDecoder().decode(file);
        } catch (IllegalArgumentException e){
            LOGGER.error("isValueBase64@message: "+ e.getMessage());
            LOGGER.error("isValueBase64@trace: ", e);
            throw new Exception("Error al decodificar el archivo en base64", e);
        }
    }
}
