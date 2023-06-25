package com.upc.trabajo_final.Trabajo.Final.security.repository;

import com.upc.trabajo_final.Trabajo.Final.security.model.Emprendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmprendedorRepository extends JpaRepository<Emprendedor, Integer> {
    @Query("SELECT e FROM Emprendedor e ORDER BY e.id DESC LIMIT 1")
    Emprendedor findLastEmprendedor();
}
