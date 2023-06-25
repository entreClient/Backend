package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.RecojoTienda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecojoTiendaRepository extends JpaRepository<RecojoTienda, Integer> {
    boolean existsByNombreAndDireccion_emprendimiento(String nombre);
}
