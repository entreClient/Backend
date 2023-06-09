package pe.com.upc.proyecto.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="gestor")
public class Gestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   @Column(name = "username", nullable = false)
    private String username;
   @Column(name="password", nullable = false)
    private String password;
    @Column(name = "rol", nullable = false)
    private String rol;



}
