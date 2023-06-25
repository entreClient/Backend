package com.upc.trabajo_final.Trabajo.Final.security.repository;

import com.upc.trabajo_final.Trabajo.Final.security.model.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GestorRepository extends JpaRepository<Gestor, Integer> {
    Gestor findByUsernameAndPassword(String username, String password);

    //Validaciones para segurity
    Optional<Gestor> findOneByUsername(String username);

    //retorna el "id" del ultimo gestor registrado
    @Query("SELECT g FROM Gestor g ORDER BY g.id DESC LIMIT 1")
    Gestor findLastGestorId();
}
