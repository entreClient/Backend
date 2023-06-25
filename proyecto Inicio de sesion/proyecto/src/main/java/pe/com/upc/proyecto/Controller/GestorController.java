package com.upc.trabajo_final.Trabajo.Final.security.controller;

import com.upc.trabajo_final.Trabajo.Final.security.model.Gestor;
import com.upc.trabajo_final.Trabajo.Final.security.service.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GestorController {
    @Autowired
    private GestorService gestorService;
    @RequestMapping(value = "api/v1/entreclient/gestor",method = RequestMethod.POST)
    public ResponseEntity<Object> createGestor(@RequestBody Gestor gestor){
        gestor=gestorService.createGestor(gestor);
        return new ResponseEntity<>("Usuario almacenado", HttpStatus.CREATED);
    }
    @RequestMapping(value = "api/v1/entreclient/gestores",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllGestor(){
        List<Gestor> gestorList=gestorService.getAllGestor();
        if(gestorList.isEmpty()){
            return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(gestorList,HttpStatus.OK);
        }
    }
}
