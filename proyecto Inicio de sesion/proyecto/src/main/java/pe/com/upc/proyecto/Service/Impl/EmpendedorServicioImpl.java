package pe.com.upc.proyecto.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.upc.proyecto.Entities.Emprendedor;
import pe.com.upc.proyecto.Entities.Emprendimiento;
import pe.com.upc.proyecto.Entities.Gestor;
import pe.com.upc.proyecto.Repository.EmprendedorRepository;
import pe.com.upc.proyecto.Service.EmprendedorServicio;
import pe.com.upc.proyecto.Service.EmprendimientoServicio;

import java.util.List;
import java.util.Optional;

@Service
public class EmpendedorServicioImpl implements EmprendedorServicio {
    @Autowired
    private EmprendedorRepository emprendedorRepository;
    @Override
    public Emprendedor createEmprendedor(Emprendedor emprendedor){
        return emprendedorRepository.save(emprendedor);
    }

    @Override
    public void updateEmprendedor(Emprendedor emprendedor) {
        emprendedorRepository.save(emprendedor);
    }

    @Override
    public Emprendedor getEmprendedorById(int id) {
        Optional<Emprendedor> optional= emprendedorRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe Emprendedor");
        }
    }

    @Override
    public void deleteEmprendedor(int id) {
        emprendedorRepository.deleteById(id);
    }

    @Override
    public List<Emprendedor> getAllEmprendedor() {
        return (List<Emprendedor>) emprendedorRepository.findAll();
    }

    @Override
    public boolean isEmprendedorExists(int id) {
        return emprendedorRepository.existsById(id);
    }
}
