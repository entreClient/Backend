package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Calificacion;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Producto;
import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
   Boolean existsCalificacionesByProductoAndClienteAndFecha(Producto producto, Cliente cliente, LocalDate fecha);
}
