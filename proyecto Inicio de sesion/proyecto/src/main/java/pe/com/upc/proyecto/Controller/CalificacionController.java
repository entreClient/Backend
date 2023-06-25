package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Calificacion;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CalificacionRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.EmprendimientoRepository;
import com.upc.trabajo_final.Trabajo.Final.security.repository.ClienteRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/entreclient/v1")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    private final CalificacionRepository calificacionRepository;
    private final EmprendimientoRepository emprendimientoRepository;
    private final ClienteRepository clienteRepository;

    public CalificacionController(CalificacionRepository calificacionRepository,
                                  EmprendimientoRepository emprendimientoRepository,
                                  ClienteRepository clienteRepository) {
        this.calificacionRepository = calificacionRepository;
        this.emprendimientoRepository = emprendimientoRepository;
        this.clienteRepository = clienteRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/calificaciones
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/calificaciones")
    public ResponseEntity<List<Calificacion>> getAllCalificaciones(){
        return new ResponseEntity<List<Calificacion>>(calificacionService.getAllCalificacion(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/calificaciones
    //Method: POST
    @Transactional
    @PostMapping("/calificaciones")
    public ResponseEntity<Calificacion> createCalificacion(@RequestBody Calificacion calificacion){
        calificacion.setFecha(LocalDate.now());
        validateCalificacion(calificacion);
        existsCalificacionesByEmprendimientoAndClienteAndFecha(calificacion);
        return new ResponseEntity<Calificacion>(calificacionService.createCalificacion(calificacion), org.springframework.http.HttpStatus.CREATED);
    }

    private void validateCalificacion(Calificacion calificacion){
        if(calificacion.getPuntaje() < 0 || calificacion.getPuntaje() > 5){
            throw new ValidationException("El puntaje debe estar entre 0 y 5");
        }
        if(calificacion.getComentario().length() > 100){
            throw new ValidationException("El comentario no debe exceder los 100 caracteres");
        }
        if(calificacion.getCliente() == null){
            throw new ValidationException("El cliente no debe ser nulo");
        }
        if(calificacion.getProducto() == null){
            throw new ValidationException("El emprendimiento no debe ser nulo");
        }
        if(calificacion.getFecha() == null){
            throw new ValidationException("La fecha no debe ser nula");
        }
    }

    private void existsCalificacionesByEmprendimientoAndClienteAndFecha(Calificacion calificacion){
        if(calificacionRepository.existsCalificacionesByProductoAndClienteAndFecha(calificacion.getProducto(), calificacion.getCliente(), calificacion.getFecha())){
            throw new ValidationException("Ya existe una calificacion para este emprendimiento y cliente en esta fecha");
        }
    }

    //URL: http://localhost:8080/api/entreclient/v1/calificaciones/{id}
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/calificaciones/{id}")
    public ResponseEntity<Calificacion> getCalificacionById(@PathVariable(value = "id") int calificacionId){
        return new ResponseEntity<Calificacion>(calificacionService.getCalificacionById(calificacionId), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/calificaciones/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/calificaciones/{id}")
    public ResponseEntity<Calificacion> updateCalificacion(@PathVariable(value = "id") int calificacionId, @RequestBody Calificacion calificacion){
        Calificacion currentCalificacion = calificacionService.getCalificacionById(calificacionId);
        return new ResponseEntity<Calificacion>(calificacionService.updateCalificacion(currentCalificacion), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/calificaciones/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/calificaciones/{id}")
    public ResponseEntity<Void> deleteCalificacion(@PathVariable(value = "id") int calificacionId){
        calificacionService.deleteCalificacion(calificacionId);
        return new ResponseEntity<Void>(org.springframework.http.HttpStatus.NO_CONTENT);
    }

}
