package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.RecojoTienda;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.RecojoTiendaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.RecojoTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreclient/v1")
public class RecojoTiendaController {
    @Autowired
    private RecojoTiendaService recojoTiendaService;

    private final RecojoTiendaRepository recojoTiendaRepository;

    public RecojoTiendaController(RecojoTiendaRepository recojoTiendaRepository) {
        this.recojoTiendaRepository = recojoTiendaRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/recojotienda
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/recojotienda")
    public ResponseEntity<List<RecojoTienda>> getAllRecojoTienda(){
        return new ResponseEntity<List<RecojoTienda>>(recojoTiendaService.getAllRecojoTienda(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/recojotienda
    //Method: POST
    @org.springframework.transaction.annotation.Transactional
    @PostMapping("/recojotienda")
    public ResponseEntity<RecojoTienda> createRecojoTienda(@org.springframework.web.bind.annotation.RequestBody RecojoTienda recojoTienda){
        recojoTienda.setType("RecojoTienda");
        return new ResponseEntity<RecojoTienda>(recojoTiendaService.createRecojoTienda(recojoTienda), org.springframework.http.HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/entreclient/v1/recojotienda
    //Method: PUT
    @Transactional
    @PutMapping("/recojotienda")
    public ResponseEntity<RecojoTienda> updateRecojoTienda(@org.springframework.web.bind.annotation.RequestBody RecojoTienda recojoTienda){
        return new ResponseEntity<RecojoTienda>(recojoTiendaService.updateRecojoTienda(recojoTienda), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/recojotienda/{id}
    //Method: DELETE
    public ResponseEntity<RecojoTienda> deleteRecojoTienda(@PathVariable("id") int id){
        recojoTiendaService.deleteRecojoTienda(id);
        return new ResponseEntity<RecojoTienda>(org.springframework.http.HttpStatus.NO_CONTENT);
    }

}
