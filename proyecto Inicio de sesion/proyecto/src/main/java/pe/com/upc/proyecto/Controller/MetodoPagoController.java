package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.MetodoPagoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entreclient")
public class MetodoPagoController {
    @Autowired
    private MetodoPagoService metodoPagoService;

    private final MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoController(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    //URL: http://localhost:8080/api/v1/entreclient/metodopago
    //Method: GET
    public ResponseEntity<List<MetodoPago>> getAllMetodoPago(){
        return new ResponseEntity<List<MetodoPago>>(metodoPagoRepository.findAll(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/metodopago
    //Method: POST
    public ResponseEntity<MetodoPago> createMetodoPago(@RequestBody MetodoPago metodoPago){
        return new ResponseEntity<MetodoPago>(metodoPagoRepository.save(metodoPago), org.springframework.http.HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/v1/entreclient/metodopago
    //Method: PUT
    public ResponseEntity<MetodoPago> updateMetodoPago(@RequestBody MetodoPago metodoPago){
        return new ResponseEntity<MetodoPago>(metodoPagoRepository.save(metodoPago), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/metodopago
    //Method: DELETE
    public ResponseEntity<MetodoPago> deleteMetodoPago(@RequestBody MetodoPago metodoPago){
        metodoPagoRepository.delete(metodoPago);
        return new ResponseEntity<MetodoPago>(org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/metodopago/{id}
    //Method: GET
    public ResponseEntity<MetodoPago> getMetodoPagoById(@RequestParam("id") int id, @RequestBody MetodoPago metodoPago){
        return new ResponseEntity<MetodoPago>(metodoPagoService.getMetodoPagoById(id), org.springframework.http.HttpStatus.OK);
    }

}
