package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Yape;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.YapeRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.YapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entreclient")
public class YapeController {
    @Autowired
    private YapeService yapeService;

    private final YapeRepository yapeRepository;

    public YapeController(YapeRepository yapeRepository) {
        this.yapeRepository = yapeRepository;
    }

    //URL: http://localhost:8080/api/v1/entreclient/yapes
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/yapes")
    public ResponseEntity<List<Yape>> getAllYapes(){
        return new ResponseEntity<List<Yape>> (yapeService.getAllYape(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/yapes
    //Method: POST
    @org.springframework.transaction.annotation.Transactional
    @PostMapping("/yapes")
    public ResponseEntity<Yape> createYape(@RequestBody Yape yape){
        yape.setType("Yape");
        validateYape(yape);
        existsYapesByNumeroCelularAndTitularAndNumeroDNI(yape);
        return new ResponseEntity<Yape>(yapeService.createYape(yape), org.springframework.http.HttpStatus.CREATED);
    }

    private void validateYape(Yape yape){
        if(yape.getNumeroCelular() == null || yape.getNumeroCelular().isEmpty()){
            throw new ValidationException("El numero celular es obligatorio");
        }
        if(yape.getTitular() == null || yape.getTitular().isEmpty()){
            throw new ValidationException("El titular es obligatorio");
        }
        if(yape.getNumeroCelular().length() != 9){
            throw new ValidationException("El numero celular debe tener 9 digitos");
        }
        if(yape.getNumeroCelular().matches("\\d+")){
            throw new ValidationException("El numero de celular no debe contener letras");
        }
        if(yape.getNumeroDNI() == null || yape.getNumeroDNI().isEmpty()){
            throw new ValidationException("El numero de DNI es obligatorio");
        }
        if(yape.getNumeroDNI().length() != 8){
            throw new ValidationException("El numero de DNI debe tener 8 digitos");
        }
        if(yape.getNumeroDNI().matches("\\d+")){
            throw new ValidationException("El numero de DNI no debe contener letras");
        }
        if(yape.getType() == null || yape.getType().isEmpty()){
            throw new ValidationException("El tipo es obligatorio");
        }
    }
    private void existsYapesByNumeroCelularAndTitularAndNumeroDNI(Yape yape){
        if(yapeRepository.existsByNumeroCelularAndTitularAndNumeroDNI(yape.getNumeroCelular(), yape.getTitular(), yape.getNumeroDNI())){
            throw new ValidationException("Ya existe un Yape con el numero celular, dni y titular ingresado");
        }
    }

    //URL: http://localhost:8080/api/v1/entreclient/yapes/{id}
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/yapes/{id}")
    public ResponseEntity<Yape> getYapeById(@PathVariable Integer id){
        return new ResponseEntity<Yape>(yapeService.getYapeById(id), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/yapes/{id}
    //Method: PUT
    @org.springframework.transaction.annotation.Transactional
    @PutMapping("/yapes/{id}")
    public ResponseEntity<Yape> updateYape(@PathVariable Integer id, @RequestBody Yape yape){
        return new ResponseEntity<Yape>(yapeService.updateYape(yape), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/yapes/{id}
    //Method: DELETE
    @org.springframework.transaction.annotation.Transactional
    @DeleteMapping("/yapes/{id}")
    public ResponseEntity<String> deleteYape(@PathVariable Integer id){
        yapeService.deleteYape(id);
        return new ResponseEntity<String>("Yape eliminado correctamente", org.springframework.http.HttpStatus.OK);
    }

}
