package pe.com.upc.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.upc.proyecto.Entities.Emprendedor;

public interface EmprendedorRepository extends JpaRepository<Emprendedor,Integer> {
}
