package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Tarjeta;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.TarjetaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public Tarjeta createTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta updateTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta getTarjetaById(int id){
        Optional<Tarjeta> optional = tarjetaRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException("Tarjeta not found for id :: " + id);
        }
    }

    @Override
    public void deleteTarjeta(int id){
        tarjetaRepository.deleteById(id);
    }

    @Override
    public List<Tarjeta> getAllTarjeta(){
        return (List<Tarjeta>) tarjetaRepository.findAll();
    }

    @Override
    public boolean isTarjetaExists(int id){
        return tarjetaRepository.existsById(id);
    }
}
