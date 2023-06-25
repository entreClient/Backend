package com.upc.trabajo_final.Trabajo.Final.security.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="emprendedor")
public class Emprendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String apellido;

    private String celular;

    private String email;

    @ManyToOne
    @JoinColumn(name = "id_gestor", nullable = false, foreignKey = @ForeignKey(name = "FK_Gestor_id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Gestor gestor;

}

