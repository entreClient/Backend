package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    boolean existsByNombre(String nombre);

}
