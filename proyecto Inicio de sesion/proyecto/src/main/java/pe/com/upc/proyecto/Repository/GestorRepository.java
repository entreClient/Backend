package pe.com.upc.proyecto.Repository;

import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.upc.proyecto.Entities.Gestor;

public interface GestorRepository extends JpaRepository<Gestor,Integer> {
    //buscar usuario
    Gestor findByUsernameAndPassword(String username, String password);

}
