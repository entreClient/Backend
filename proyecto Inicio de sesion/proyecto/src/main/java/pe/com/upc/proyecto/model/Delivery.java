package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "delivery")
@Entity
public class Delivery extends MetodoEnvio{
    private String direccion;
}
