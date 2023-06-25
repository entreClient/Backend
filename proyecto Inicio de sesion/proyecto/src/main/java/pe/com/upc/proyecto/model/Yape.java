package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="yape")
public class Yape extends MetodoPago{

    @Column(name = "numero_celular", nullable = false, length = 9)
    private String numeroCelular;

    private String titular;

    @Column(name = "numero_dni", nullable = false, length = 8)
    private String numeroDNI;
}


