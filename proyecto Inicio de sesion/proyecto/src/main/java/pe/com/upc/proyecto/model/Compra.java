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
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "Cliente_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Pago_Cliente"))
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "Metodo_Pago_id", nullable = false, foreignKey = @ForeignKey(name = "FK_METODO_PAGO"))
    private MetodoPago metodoPago;

    @ManyToOne
    @JoinColumn(name = "Metodo_Envio_id", nullable = false, foreignKey = @ForeignKey(name = "FK_METODO_ENVIO"))
    private MetodoEnvio metodoEnvio;
}
