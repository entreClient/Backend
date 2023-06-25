package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Yape;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YapeRepository extends JpaRepository<Yape, Integer> {
    Boolean existsByNumeroCelularAndTitularAndNumeroDNI(String numeroCelular, String titular, String numeroDNI);
}
