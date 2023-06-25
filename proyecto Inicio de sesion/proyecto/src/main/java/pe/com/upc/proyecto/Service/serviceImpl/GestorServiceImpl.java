package com.upc.trabajo_final.Trabajo.Final.security.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.security.model.Gestor;
import com.upc.trabajo_final.Trabajo.Final.security.repository.GestorRepository;
import com.upc.trabajo_final.Trabajo.Final.security.service.GestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestorServiceImpl implements GestorService {
    @Autowired
    private GestorRepository gestorRepository;

    @Override
    public Gestor createGestor(Gestor gestor){
        return gestorRepository.save(gestor);
    }

    @Override
    public void updateGestor(Gestor gestor) {
        gestorRepository.save(gestor);
    }



    @Override
    public Gestor getGestorById(int id) {
        Optional<Gestor> optional= gestorRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe ususario");
        }
    }

    @Override
    public void deleteGestor(int id) {
        gestorRepository.deleteById(id);
    }

    @Override
    public List<Gestor> getAllGestor() {
        return (List<Gestor>) gestorRepository.findAll();
    }
    @Override
    public boolean isGestorExists(int id){return gestorRepository.existsById(id);}

    @Override
    public Gestor findLastGestor(){ return gestorRepository.findLastGestorId();};

}
