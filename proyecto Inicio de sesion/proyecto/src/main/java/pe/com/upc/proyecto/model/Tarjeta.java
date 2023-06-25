package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarjeta")
public class Tarjeta extends MetodoPago{

    @Column(name = "numero_tarjeta", nullable = false, length = 16)
    private String numeroTarjeta;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    private String cvv;

    @Column(name = "nombre_tarjeta", nullable = false, length = 30)
    private String nombreTarjeta;

}

