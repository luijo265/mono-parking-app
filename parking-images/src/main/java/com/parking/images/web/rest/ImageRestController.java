package com.parking.images.web.rest;

import com.parking.images.domain.ImageVehicule;
import com.parking.images.domain.dto.CreateFileDto;
import com.parking.images.domain.dto.ResponseRestDto;
import com.parking.images.domain.service.ImageVehiculeServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageRestController {

    @Autowired
    private ImageVehiculeServiceImpl imageVehiculeService;

    @GetMapping
    @ApiOperation("Obtener todas las imagenes guardas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ImageVehicule>> getImageVehicules(){
        return new ResponseEntity<>(imageVehiculeService.getImageVehicules(), HttpStatus.OK);
    }

    @GetMapping("{imageId}")
    @ApiOperation("Obtener una imagen")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Imagen no encontrada")
    })
    public ResponseEntity<ResponseRestDto> getImageVehicule(@ApiParam(value = "Id de la imagen", defaultValue = "23132435168") @PathVariable("imageId") String imageId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageVehiculeService.getImageVehicule(imageId));
    }

    @PostMapping
    public ResponseEntity<ResponseRestDto> saveImage(@Valid @RequestBody CreateFileDto createFile) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(imageVehiculeService.saveImageVehicule(createFile.getFile()));
    }

}
