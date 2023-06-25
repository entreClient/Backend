package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;

import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer puntaje;

    private String comentario;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "Producto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Emprendedor_id"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "Cliente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Cliente_id"))
    private Cliente cliente;
}

