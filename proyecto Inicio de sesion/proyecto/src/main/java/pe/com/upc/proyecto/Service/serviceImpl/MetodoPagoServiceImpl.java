package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.MetodoPagoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.MetodoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public MetodoPago createMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    @Override
    public void updateMetodoPago(MetodoPago metodoPago) {
        metodoPagoRepository.save(metodoPago);
    }

    @Override
    public MetodoPago getMetodoPagoById(int id){
        Optional<MetodoPago> optional = metodoPagoRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException("MetodoPago not found for id :: " + id);
        }
    }

    @Override
    public void deleteMetodoPago(int id){
        metodoPagoRepository.deleteById(id);
    }

    @Override
    public List<MetodoPago> getAllMetodoPago(){
        return (List<MetodoPago>) metodoPagoRepository.findAll();
    }

    @Override
    public boolean isMetodoPagoExists (int id){
        return metodoPagoRepository.existsById(id);
    }
}
