package com.parking.images.domain.service;

import com.parking.images.domain.ImageVehicule;
import com.parking.images.domain.dto.ResponseRestDto;
import com.parking.images.domain.reader.ImageReaderFeature;
import com.parking.images.domain.repository.ImageVehiculeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ImageVehiculeServiceTest {

    @InjectMocks
    private ImageVehiculeServiceImpl service;

    @Mock
    private ImageVehiculeRepository repository;

    @Mock
    private ImageReaderFeature reader;

    @Test
    public void getImageVehiculeTest() throws Exception {
        // Assets
        String imageId = "1";
        Optional<ImageVehicule> vehicule = Optional.of(mock(ImageVehicule.class));

        // Act
        when(repository.getImageVehicule(imageId)).thenReturn(vehicule);
        ResponseRestDto response = service.getImageVehicule(imageId);

        // Assert
        assertNotNull(response.getData());
    }

    @Test
    public void getImageVehiculeNotFoundTest() throws Exception {
        // Assets
        String imageId = "1";
        String getMessage = "Vehiculo no encontrado";
        Optional<ImageVehicule> vehicule = Optional.ofNullable(null);

        // Act
        when(repository.getImageVehicule(imageId)).thenReturn(vehicule);
        Exception exception = assertThrows(Exception.class, () -> {
            service.getImageVehicule(imageId);
        });

        // Assert
        assertEquals(getMessage, exception.getMessage());
    }

}
