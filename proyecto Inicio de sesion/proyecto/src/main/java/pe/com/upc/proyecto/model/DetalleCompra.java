package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
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
@Table(name = "detalle_compra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Producto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Producto_id"))
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "Pago_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Pago_id"))
    private Compra pago;

    private Integer cantidad;
}


