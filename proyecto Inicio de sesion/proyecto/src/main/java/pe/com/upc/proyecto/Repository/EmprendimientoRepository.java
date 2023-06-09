package pe.com.upc.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.upc.proyecto.Entities.Emprendimiento;

public interface EmprendimientoRepository extends JpaRepository<Emprendimiento,Integer> {
}
