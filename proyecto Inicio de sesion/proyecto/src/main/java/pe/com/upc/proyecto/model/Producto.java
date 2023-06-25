package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;

@CrossOrigin(origins = "http://localhost:4200")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "producto")
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String image;

    @Column(name = "precio_unitario", nullable = false, precision = 8, scale = 2)
    private BigDecimal precioUnitario;

    private Integer stock;

    private String genero;

    @ManyToOne
    @JoinColumn(name = "Categoria_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Categoria_id"))
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "Emprendimiento_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Emprendimiento_id"))
    private Emprendimiento emprendimiento;

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", stock=" + stock + "]";
    }
}

