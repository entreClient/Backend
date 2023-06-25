package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Emprendimiento;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.EmprendimientoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entreclient")
public class EmprendimientoController {
    @Autowired
    private EmprendimientoService emprendimientoService;

    private final EmprendimientoRepository emprendimientoRepository;

    public EmprendimientoController(EmprendimientoRepository emprendimientoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
    }

    //URL: http://localhost:8080/api/v1/entreclient/emprendimientos
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/emprendimientos")
    public ResponseEntity<List<Emprendimiento>> getAllEmprendimientos(){
        return new ResponseEntity<List<Emprendimiento>>(emprendimientoRepository.findAll(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/emprendimientos
    //Method: POST
    @org.springframework.transaction.annotation.Transactional
    @PostMapping("/emprendimientos")
    public ResponseEntity<Emprendimiento> createEmprendimiento(Emprendimiento emprendimiento){
        existsEmprendimientoByNombre(emprendimiento);
        validateEmprendimiento(emprendimiento);
        return new ResponseEntity<Emprendimiento>(emprendimientoService.createEmprendimiento(emprendimiento), org.springframework.http.HttpStatus.CREATED);
    }


    private void existsEmprendimientoByNombre(Emprendimiento emprendimiento) {
        if(emprendimientoRepository.existsByNombre(emprendimiento.getNombre())){
            throw new ValidationException("El nombre del emprendimiento ya existe");
        }
    }

    private void validateEmprendimiento(Emprendimiento emprendimiento){
        if(emprendimiento.getNombre() == null || emprendimiento.getNombre().isEmpty()){
            throw new ValidationException("El nombre del emprendimiento es obligatorio");
        }
        if(emprendimiento.getDescripcion() == null || emprendimiento.getDescripcion().isEmpty()){
            throw new ValidationException("La descripcion del emprendimiento es obligatorio");
        }
        if(emprendimiento.getDireccion() == null || emprendimiento.getDireccion().isEmpty()){
            throw new ValidationException("La direccion del emprendimiento es obligatorio");
        }
        if(emprendimiento.getDireccion().length() > 100){
            throw new ValidationException("La direccion del emprendimiento no debe exceder los 100 caracteres");
        }

    }

    //URL: http://localhost:8080/api/v1/entreclient/emprendimientos/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/emprendimientos/{id}")
    public ResponseEntity<Emprendimiento> updateEmprendimiento(@PathVariable("id") int emprendimientoId, @RequestBody Emprendimiento emprendimiento){
        Emprendimiento currentEmprendimiento = emprendimientoRepository.findById(emprendimientoId).orElseThrow(() -> new ValidationException("El emprendimiento no existe"));
        currentEmprendimiento.setNombre(emprendimiento.getNombre());
        currentEmprendimiento.setDescripcion(emprendimiento.getDescripcion());
        currentEmprendimiento.setDireccion(emprendimiento.getDireccion());
        return new ResponseEntity<Emprendimiento>(emprendimientoService.updateEmprendimiento(currentEmprendimiento), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/emprendimientos/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/emprendimientos/{id}")
    public ResponseEntity<Emprendimiento> deleteEmprendimiento(@PathVariable("id") int emprendimientoId){
        emprendimientoService.deleteEmprendimiento(emprendimientoId);
        return new ResponseEntity<Emprendimiento>(org.springframework.http.HttpStatus.NO_CONTENT);
    }

    //URL: http://localhost:8080/api/v1/entreclient/emprendimientos/{id}
    //Method: GET
    @Transactional
    @GetMapping("/emprendimientos/{id}")
    public ResponseEntity<Emprendimiento> getEmprendimientoById(@PathVariable("id") int emprendimientoId){
        return new ResponseEntity<Emprendimiento>(emprendimientoService.getEmprendimientoById(emprendimientoId), org.springframework.http.HttpStatus.OK);
    }
}
