package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;


import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoEnvioRepository extends JpaRepository<MetodoEnvio, Integer> {
    boolean existsByNombre(String nombre);
}
