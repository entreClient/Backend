package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Rubro;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.RubroRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.RubroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreclient/v1")
public class RubroController {
    @Autowired
    private RubroService rubroService;

    private final RubroRepository rubroRepository;

    public RubroController(RubroRepository rubroRepository) {
        this.rubroRepository = rubroRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/rubros
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/rubros")
    public ResponseEntity<List<Rubro>> getAllRubros(){
        return new ResponseEntity<List<Rubro>>(rubroRepository.findAll(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/rubros
    //Method: POST
    @Transactional
    @PostMapping("/rubros")
    public ResponseEntity<Rubro> createRubro(Rubro rubro){
        existsRubrosByNombreRubro(rubro);
        validateRubro(rubro);
        return new ResponseEntity<Rubro>(rubroService.createRubro(rubro), org.springframework.http.HttpStatus.CREATED);
    }

    private void existsRubrosByNombreRubro(Rubro rubro){
        if(rubroRepository.existsByNombre(rubro.getNombre())){
            throw new ValidationException("El nombre del rubro ya existe");
        }
    }
    private void validateRubro(Rubro rubro){
        if(rubro.getNombre() == null || rubro.getNombre().isEmpty()){
            throw new ValidationException("El nombre del rubro no debe estar vacio");
        }
        if(rubro.getNombre().length() > 40){
            throw new ValidationException("El nombre del rubro no debe exceder los 40 caracteres");
        }
    }

    //URL: http://localhost:8080/api/entreclient/v1/rubros/{id}
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/rubros/{id}")
    public ResponseEntity<Rubro> getRubroById(@PathVariable("id") Integer id){
        return new ResponseEntity<Rubro>(rubroService.getRubroById(id), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/rubros/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/rubros/{id}")
    public ResponseEntity<Rubro> updateRubro(@PathVariable("id") Integer id, @RequestBody Rubro rubro){
        Rubro rubroDB = rubroService.getRubroById(id);
        if(rubroDB == null){
            return new ResponseEntity<Rubro>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        rubro.setId(id);
        return new ResponseEntity<Rubro>(rubroService.updateRubro(rubro), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/rubros/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/rubros/{id}")
    public ResponseEntity<Rubro> deleteRubro(@PathVariable("id") Integer id){
        Rubro rubroDB = rubroService.getRubroById(id);
        if(rubroDB == null){
            return new ResponseEntity<Rubro>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        rubroService.deleteRubro(rubroDB.getId());
        return new ResponseEntity<Rubro>(org.springframework.http.HttpStatus.OK);
    }

}
