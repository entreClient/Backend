package pe.com.upc.proyecto.Service;

import org.springframework.beans.factory.annotation.Autowired;
import pe.com.upc.proyecto.Entities.Emprendedor;
import pe.com.upc.proyecto.Entities.Emprendimiento;
import pe.com.upc.proyecto.Entities.Gestor;

import java.util.List;

public interface EmprendedorServicio {

    public abstract Emprendedor createEmprendedor(Emprendedor emprendedor);
    public abstract void updateEmprendedor(Emprendedor emprendedor);
    public abstract Emprendedor getEmprendedorById(int id);
    public abstract void deleteEmprendedor(int id);
    public abstract List<Emprendedor> getAllEmprendedor();
    public abstract boolean isEmprendedorExists(int id);

}
