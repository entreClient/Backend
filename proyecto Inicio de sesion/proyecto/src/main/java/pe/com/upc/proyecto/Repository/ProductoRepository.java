package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Categoria;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Emprendimiento;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Boolean existsByNombre(String nombre);
    Producto findByIdAndCategoriaAndEmprendimiento(Integer id, Categoria categoria, Emprendimiento emprendimiento);
}
