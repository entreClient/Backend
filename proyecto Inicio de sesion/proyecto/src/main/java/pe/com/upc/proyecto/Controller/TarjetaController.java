package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Tarjeta;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.TarjetaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/entreclient")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;

    private final TarjetaRepository tarjetaRepository;

    public TarjetaController(TarjetaRepository tarjetaRepository) {
        this.tarjetaRepository = tarjetaRepository;
    }

    //URL: http://localhost:8080/api/bank/v1/tarjetas
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/accounts")
    public ResponseEntity<List<Tarjeta>> getAllAccounts(){
        return new ResponseEntity<List<Tarjeta>>(tarjetaRepository.findAll(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/tarjetas
    //Method: POST
    @Transactional
    @PostMapping("/tarjetas")
    public ResponseEntity<Tarjeta> createTarjeta(@RequestBody Tarjeta tarjeta){
        tarjeta.setType("Tarjeta");
        existsTarjetasByNumeroTarjetaAndNombreTarjeta(tarjeta);
        validateTarjeta(tarjeta);
        return new ResponseEntity<Tarjeta>(tarjetaService.createTarjeta(tarjeta), org.springframework.http.HttpStatus.CREATED);
    }

    private void existsTarjetasByNumeroTarjetaAndNombreTarjeta(Tarjeta tarjeta){
        if(tarjetaRepository.existsByNumeroTarjetaAndNombreTarjeta(tarjeta.getNumeroTarjeta(), tarjeta.getNombreTarjeta())){
            throw new ValidationException("Ya existe una tarjeta con el mismo numero y nombre");
        }
    }

    private void validateTarjeta(Tarjeta tarjeta){
        if(tarjeta.getNumeroTarjeta() == null || tarjeta.getNumeroTarjeta().isEmpty()){
            throw new ValidationException("El numero de tarjeta no debe estar vacio");
        }
        if(tarjeta.getNombreTarjeta() == null || tarjeta.getNombreTarjeta().isEmpty()){
            throw new ValidationException("El nombre de tarjeta no debe estar vacio");
        }
        if(tarjeta.getFechaVencimiento() == null){
            throw new ValidationException("La fecha de vencimiento no debe estar vacio");
        }
        if(tarjeta.getCvv() == null || tarjeta.getCvv().isEmpty()){
            throw new ValidationException("El codigo de seguridad no debe estar vacio");
        }
        if(tarjeta.getType() == null || tarjeta.getType().isEmpty()){
            throw new ValidationException("El tipo de tarjeta no debe estar vacio");
        }
        if(tarjeta.getNumeroTarjeta().length() != 16){
            throw new ValidationException("El numero de tarjeta debe tener 16 digitos");
        }
        if(tarjeta.getFechaVencimiento().isBefore(LocalDate.now())){
            throw new ValidationException("La fecha de vencimiento no debe ser menor a la fecha actual");
        }
        if(tarjeta.getCvv().length() != 3){
            throw new ValidationException("El codigo de seguridad debe tener 3 digitos");
        }
        if (tarjeta.getNombreTarjeta().matches("\\d+")) {
            throw new ValidationException("El nombre de tarjeta no debe contener números");
        }
        if(tarjeta.getCvv().matches("\\d+")){
            throw new ValidationException("El codigo de seguridad no debe contener letras");
        }
    }

    //URL: http://localhost:8080/api/v1/entreclient/tarjetas/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/tarjetas/{id}")
    public ResponseEntity<Tarjeta> updateTarjeta(@PathVariable Integer id, @RequestBody Tarjeta tarjeta){
        Tarjeta tarjetaDB = tarjetaRepository.findById(id).orElse(null);
        if(tarjetaDB == null){
            throw new ValidationException("No existe la tarjeta con el id: " + id);
        }
        tarjetaDB.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        tarjetaDB.setNombreTarjeta(tarjeta.getNombreTarjeta());
        tarjetaDB.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaDB.setCvv(tarjeta.getCvv());
        tarjetaDB.setType(tarjeta.getType());
        return new ResponseEntity<Tarjeta>(tarjetaService.updateTarjeta(tarjetaDB), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/tarjetas/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/tarjetas/{id}")
    public ResponseEntity<String> deleteTarjeta(@PathVariable Integer id){
        Tarjeta tarjetaDB = tarjetaRepository.findById(id).orElse(null);
        if(tarjetaDB == null){
            throw new ValidationException("No existe la tarjeta con el id: " + id);
        }
        tarjetaService.deleteTarjeta(tarjetaDB.getId());
        return new ResponseEntity<String>("La tarjeta se eliminó correctamente", org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/tarjetas/{id}
    //Method: GET
    @Transactional
    @GetMapping("/tarjetas/{id}")
    public ResponseEntity<Tarjeta> getTarjetaById(@PathVariable Integer id){
        Tarjeta tarjetaDB = tarjetaRepository.findById(id).orElse(null);
        if(tarjetaDB == null){
            throw new ValidationException("No existe la tarjeta con el id: " + id);
        }
        return new ResponseEntity<Tarjeta>(tarjetaService.getTarjetaById(tarjetaDB.getId()), org.springframework.http.HttpStatus.OK);
    }
}
