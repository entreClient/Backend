package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    Boolean existsByDireccionAndType(String direccion, String type);
}
