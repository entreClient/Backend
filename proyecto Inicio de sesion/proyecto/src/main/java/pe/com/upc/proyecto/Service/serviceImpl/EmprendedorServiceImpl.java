package com.upc.trabajo_final.Trabajo.Final.security.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.security.model.Emprendedor;
import com.upc.trabajo_final.Trabajo.Final.security.repository.EmprendedorRepository;
import com.upc.trabajo_final.Trabajo.Final.security.service.EmprendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprendedorServiceImpl implements EmprendedorService {
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

    @Override
    public Emprendedor findLastEmprendedorId(){ return emprendedorRepository.findLastEmprendedor();};

}
