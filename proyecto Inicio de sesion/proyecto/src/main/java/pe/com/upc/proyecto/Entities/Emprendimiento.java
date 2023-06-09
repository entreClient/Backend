package pe.com.upc.proyecto.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="emprendimientos")
public class Emprendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_empresa",nullable = false) //aqui se coloca las restrcciones
    private String nombre_empresa;
    @Column(name = "descripcion",nullable = false)
    private String descripcion;
    @Column(name = "rubro",nullable = false)
    private String rubro;

    @ManyToOne
    @JoinColumn(name="id_emprendedor", nullable = false,foreignKey = @ForeignKey(name="FK_EMPRENDEDOR_ID")) //foreingKey es op¿cional
    private Emprendedor id_emprendedor;



}
