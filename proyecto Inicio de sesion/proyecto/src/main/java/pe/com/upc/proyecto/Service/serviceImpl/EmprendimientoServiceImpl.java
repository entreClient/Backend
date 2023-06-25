package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Emprendimiento;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.EmprendimientoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprendimientoServiceImpl implements EmprendimientoService {
    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    @Override
    public Emprendimiento createEmprendimiento(Emprendimiento emprendimiento){
        return emprendimientoRepository.save(emprendimiento);
    }

    @Override
    public Emprendimiento updateEmprendimiento(Emprendimiento emprendimiento){
        return emprendimientoRepository.save(emprendimiento);
    }

    @Override
    public void deleteEmprendimiento(int id){
        emprendimientoRepository.deleteById(id);
    }

    @Override
    public Emprendimiento getEmprendimientoById(int id){
        Optional<Emprendimiento> optional = emprendimientoRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException(" Emprendimiento not found for id :: " + id);
        }
    }

    @Override
    public List<Emprendimiento> getAllEmprendimiento(){
        return emprendimientoRepository.findAll();
    }

    @Override
    public boolean isEmprendimientoExists(int id){
        return emprendimientoRepository.existsById(id);
    }

}
