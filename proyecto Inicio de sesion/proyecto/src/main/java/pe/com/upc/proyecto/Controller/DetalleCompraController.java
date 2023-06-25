package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.DetalleCompra;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.DetalleCompraRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entreclient")
public class DetalleCompraController {
    private final DetalleCompraRepository detallePagoRepository;

    public DetalleCompraController(DetalleCompraRepository detallePagoRepository) {
        this.detallePagoRepository = detallePagoRepository;
    }

    // URL: http://localhost:8080/api/v1/entreclient/detallePagos/{id}
    // Method: GET
    @GetMapping("/detallePagos/{id}")
    public ResponseEntity<DetalleCompra> getDetallePagoById(@PathVariable("id") Integer id) {
        DetalleCompra detallePago = detallePagoRepository.findDetallePagoWithRelations(id);
        return new ResponseEntity<>(detallePago, HttpStatus.OK);
    }
}
