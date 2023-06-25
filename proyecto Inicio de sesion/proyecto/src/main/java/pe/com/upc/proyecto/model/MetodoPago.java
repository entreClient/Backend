package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="metodo_pago")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String type;

}

