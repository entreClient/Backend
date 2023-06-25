package com.upc.trabajo_final.Trabajo.Final.security.controller;

import com.upc.trabajo_final.Trabajo.Final.security.model.Emprendedor;
import com.upc.trabajo_final.Trabajo.Final.security.repository.EmprendedorRepository;
import com.upc.trabajo_final.Trabajo.Final.security.service.EmprendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entreclient")
public class EmprendedorController {
    @Autowired
    private EmprendedorService emprendedorService;
    @Autowired
    private EmprendedorRepository emprendedorRepository;


    //URL: http://localhost:8080/api/v1/entreclient/emprendedor
    //Method: POST
    @Transactional
    @PostMapping("/emprendedor")
    public ResponseEntity<Object> createEmprendedor(@RequestBody Emprendedor emprendedor){
        emprendedor=emprendedorService.createEmprendedor(emprendedor);
        return new ResponseEntity<>("Emprendedor creado", HttpStatus.CREATED);
    }

    @Transactional(readOnly = true)
    @GetMapping("/emprendedor")
    public ResponseEntity<List<Emprendedor>> getAllEmprendedor(){
        return new ResponseEntity<List<Emprendedor>>(emprendedorService.getAllEmprendedor(), HttpStatus.OK);
    }

    @GetMapping("/emprendedor/ultimo")
    public ResponseEntity<Emprendedor> findLastEmprendedorId() {
        Emprendedor emprendedor = emprendedorRepository.findLastEmprendedor();
        return new ResponseEntity<>(emprendedor, HttpStatus.OK);
    }

}
