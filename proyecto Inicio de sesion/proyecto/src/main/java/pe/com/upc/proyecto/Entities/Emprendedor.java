package pe.com.upc.proyecto.Entities;

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
@Table(name="emprendedor")
public class Emprendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellido",nullable = false)
    private String apellido;
    @Column(name = "celular", length = 11,nullable = false)
    private String celular;

    @Column(name = "email",nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name = "id_gestor", foreignKey = @ForeignKey(name = "FK_EMP_GESTOR"))
    private Gestor id_gestor;









}
