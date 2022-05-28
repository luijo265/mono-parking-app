package com.parking.images.domain.service;

import com.parking.images.domain.ImageVehicule;
import com.parking.images.domain.dto.ImageVehiculeDto;
import com.parking.images.domain.dto.ResponseRestDto;
import com.parking.images.domain.reader.ImageReaderFeature;
import com.parking.images.domain.repository.ImageVehiculeRepository;
import com.parking.images.web.exception.ElementoNoEncontradoException;
import com.parking.images.web.exception.ValidacionException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImageVehiculeServiceImpl implements ImageVehiculeService {

    private final Log LOGGER = LogFactory.getLog(ImageVehiculeServiceImpl.class);

    @Autowired
    private ImageVehiculeRepository imageVehiculeRepository;

    @Autowired
    private ImageReaderFeature reader;

    public List<ImageVehicule> getImageVehicules(){
        return imageVehiculeRepository.getImageVehicules();
    }

    @Override
    public ResponseRestDto<Object> getImageVehicule(String imageId) throws Exception {
        try {

            Optional<ImageVehicule> vehicule = imageVehiculeRepository.getImageVehicule(imageId);
            checkIsPresentVehicule(vehicule);
            Map<String, String> features = getFeaturesFromImage(vehicule.get().getFile());
            return ResponseRestDto.builder()
                    .status(HttpStatus.OK.value())
                    .data(ImageVehiculeDto.builder()
                            .imageId(vehicule.get().getImageId())
                            .file(vehicule.get().getImageId())
                            .features(features)
                            .build())
                    .build();

        } catch (Exception e) {
            LOGGER.error("getImageVehicule@message: "+ e.getMessage());
            LOGGER.error("getImageVehicule@trace: ", e);
            throw new Exception(e.getMessage(), e);
        }
    }

    private Map<String, String> getFeaturesFromImage(String file) {
        return reader.readFeatureFromImageBase64(file);
    }

    private void checkIsPresentVehicule(Optional<ImageVehicule> vehicule) throws ElementoNoEncontradoException {
        if (!vehicule.isPresent())
            throw new ElementoNoEncontradoException(
                "Vehiculo no encontrado",
                "Vehiculo no encontrado"
            );
    }

    @Override
    public ResponseRestDto<Object> saveImageVehicule(String file) throws Exception {
        try {

            isValueBase64(file);
            imageVehiculeRepository.saveImageVehicule(file);

            return ResponseRestDto.builder()
                    .status(HttpStatus.CREATED.value())
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
            throw new ValidacionException(e.getMessage(), "Error al decodificar el archivo en base64", e);
        }
    }
}
