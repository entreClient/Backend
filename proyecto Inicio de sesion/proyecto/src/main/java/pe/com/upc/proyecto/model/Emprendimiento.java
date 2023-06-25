package com.upc.trabajo_final.Trabajo.Final.Entreclient.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.upc.trabajo_final.Trabajo.Final.security.model.Emprendedor;
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
@Table(name = "emprendimiento")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descripcion;

    private String direccion;

    @ManyToOne
    @JoinColumn(name = "Rubro_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Rubro_id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Rubro rubro;

    @ManyToOne
    @JoinColumn(name = "Emprendedor_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Emprendedor_id"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Emprendedor emprendedor;

}

