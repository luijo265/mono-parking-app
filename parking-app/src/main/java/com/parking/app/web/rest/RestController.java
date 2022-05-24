package com.parking.app.web.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
public class RestController {

    @PostMapping("ocupar")
    public String ocuparPuesto(){
        return "Hola";
    }

}
