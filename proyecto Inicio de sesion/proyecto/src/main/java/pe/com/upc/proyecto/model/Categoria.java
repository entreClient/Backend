package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    @Override
    public String toString() {
            return "Categoria [id=" + id + ", nombre=" + nombre + "]";
    }
}


