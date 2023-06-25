package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoEnvio;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.MetodoEnvioRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.MetodoEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreclient/v1")
public class MetodoEnvioController {
    @Autowired
    private MetodoEnvioService metodoEnvioService;

    private final MetodoEnvioRepository metodoEnvioRepository;

    public MetodoEnvioController(MetodoEnvioRepository metodoEnvioRepository) {
        this.metodoEnvioRepository = metodoEnvioRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/metodoenvio
    //GET
    @Transactional
    @GetMapping("/metodoenvio")
    public ResponseEntity<List<MetodoEnvio>> getAllMetodoEnvio(){
        return new ResponseEntity<List<MetodoEnvio>>(metodoEnvioService.getAllMetodoEnvio(), org.springframework.http.HttpStatus.OK);
    }


    //URL: http://localhost:8080/api/entreclient/v1/metodoenvio
    //POST
    @Transactional
    @PostMapping("/metodoenvio")
    public ResponseEntity<MetodoEnvio> createMetodoEnvio(MetodoEnvio metodoEnvio){
        return new ResponseEntity<MetodoEnvio>(metodoEnvioService.createMetodoEnvio(metodoEnvio), org.springframework.http.HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/entreclient/v1/metodoenvio
    //PUT
    @Transactional
    @PutMapping("/metodoenvio")
    public ResponseEntity<MetodoEnvio> updateMetodoEnvio(MetodoEnvio metodoEnvio){
        return new ResponseEntity<MetodoEnvio>(metodoEnvioService.updateMetodoEnvio(metodoEnvio), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/metodoenvio/{id}
    //DELETE
    @Transactional
    @DeleteMapping("/calificaciones/{id}")
    public ResponseEntity<Void> deleteCalificacion(@PathVariable(value = "id") int metodoEnvioId){
        metodoEnvioService.deleteMetodoEnvio(metodoEnvioId);
        return new ResponseEntity<Void>(org.springframework.http.HttpStatus.NO_CONTENT);
    }

}
