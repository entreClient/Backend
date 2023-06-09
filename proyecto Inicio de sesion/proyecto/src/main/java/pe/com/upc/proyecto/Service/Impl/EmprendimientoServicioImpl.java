package pe.com.upc.proyecto.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.upc.proyecto.Entities.Emprendimiento;

import pe.com.upc.proyecto.Repository.EmprendimientoRepository;
import pe.com.upc.proyecto.Service.EmprendimientoServicio;

import java.util.List;
import java.util.Optional;

@Service
public class EmprendimientoServicioImpl implements EmprendimientoServicio {
    @Autowired
    private EmprendimientoRepository emprendimientoRepository ;

    @Override
    public Emprendimiento createEmprendimiento(Emprendimiento emprendimiento){
        return emprendimientoRepository.save(emprendimiento);
    }

    @Override
    public void updateEmprendimiento(Emprendimiento emprendimiento) {
        emprendimientoRepository.save(emprendimiento);
    }

    @Override
    public Emprendimiento getEmprendimientoById(int id) {
        Optional<Emprendimiento> optional= emprendimientoRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe emprendimiento");
        }
    }

    @Override
    public void deleteEmprendimiento(int id) {
        emprendimientoRepository.deleteById(id);
    }

    @Override
    public List<Emprendimiento> getAllEmprendimiento() {
        return (List<Emprendimiento>) emprendimientoRepository.findAll();
    }

    @Override
    public boolean isEmprendimientoExists(int id) {
        return emprendimientoRepository.existsById(id);
    }
}
