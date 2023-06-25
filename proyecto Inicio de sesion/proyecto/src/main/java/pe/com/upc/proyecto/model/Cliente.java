package com.upc.trabajo_final.Trabajo.Final.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido;

    private String celular;

    private String email;

    @ManyToOne
    @JoinColumn(name = "id_gestor", nullable = false, foreignKey = @ForeignKey(name = "FK_GESTOR_ID"))
    private Gestor gestor;

}

