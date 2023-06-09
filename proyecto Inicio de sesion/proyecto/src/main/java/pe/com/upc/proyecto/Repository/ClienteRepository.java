package pe.com.upc.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.upc.proyecto.Entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
