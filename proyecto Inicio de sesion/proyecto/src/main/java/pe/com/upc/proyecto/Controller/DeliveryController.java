package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Delivery;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.DeliveryRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/entreclient")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    private final DeliveryRepository deliveryRepository;

    public DeliveryController(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/delivery
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/delivery")
    public ResponseEntity<List<Delivery>> getAllDelivery(){
        return new ResponseEntity<List<Delivery>>(deliveryService.getAllDelivery(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/delivery
    //Method: POST
    @org.springframework.transaction.annotation.Transactional
    @PostMapping("/delivery")
    public ResponseEntity<Delivery> createDelivery(@org.springframework.web.bind.annotation.RequestBody Delivery delivery){
        delivery.setType("Delivery");
        return new ResponseEntity<Delivery>(deliveryService.createDelivery(delivery), org.springframework.http.HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/entreclient/v1/delivery
    //Method: PUT
    @org.springframework.transaction.annotation.Transactional
    @PutMapping("/delivery")
    public ResponseEntity<Delivery> updateDelivery(@org.springframework.web.bind.annotation.RequestBody Delivery delivery){
        return new ResponseEntity<Delivery>(deliveryService.updateDelivery(delivery), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/delivery/{id}
    //Method: DELETE
    @org.springframework.transaction.annotation.Transactional
    @DeleteMapping("/delivery/{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable("id") Integer id){
        deliveryService.deleteDelivery(id);
        return new ResponseEntity<String>("Delivery eliminado", org.springframework.http.HttpStatus.OK);
    }

}
