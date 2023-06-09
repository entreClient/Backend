package pe.com.upc.proyecto.Service;

import pe.com.upc.proyecto.Entities.Emprendimiento;
import pe.com.upc.proyecto.Entities.Gestor;

import java.util.List;

public interface EmprendimientoServicio {


    public abstract Emprendimiento createEmprendimiento(Emprendimiento emprendimiento);
    public abstract void updateEmprendimiento(Emprendimiento emprendimiento);
    public abstract Emprendimiento getEmprendimientoById(int id);
    public abstract void deleteEmprendimiento(int id);
    public abstract List<Emprendimiento> getAllEmprendimiento();
    public abstract boolean isEmprendimientoExists(int id);

}
