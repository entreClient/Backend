package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;

import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
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
@Table(name = "metodo_envio")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MetodoEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String type;

}
