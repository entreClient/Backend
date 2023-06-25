package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Calificacion;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CalificacionRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServiceImpl implements CalificacionService {
    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public Calificacion createCalificacion(Calificacion calificacion){

        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion updateCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion getCalificacionById(int id) {
        Optional<Calificacion> optional= calificacionRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe calificacion");
        }
    }

    @Override
    public void deleteCalificacion(int id) {
        calificacionRepository.deleteById(id);
    }

    @Override
    public List<Calificacion> getAllCalificacion() {
        return (List<Calificacion>) calificacionRepository.findAll();
    }

    @Override
    public boolean isCalificacionExists(int id) {
        return calificacionRepository.existsById(id);
    }

}
