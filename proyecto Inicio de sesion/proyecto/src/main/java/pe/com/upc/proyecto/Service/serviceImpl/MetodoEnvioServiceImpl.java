package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoEnvio;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.MetodoEnvioRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.MetodoEnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetodoEnvioServiceImpl implements MetodoEnvioService {
    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    @Override
    public MetodoEnvio createMetodoEnvio(MetodoEnvio metodoEnvio){
        return metodoEnvioRepository.save(metodoEnvio);
    }

    @Override
    public MetodoEnvio updateMetodoEnvio(MetodoEnvio metodoEnvio) {
        return metodoEnvioRepository.save(metodoEnvio);
    }

    @Override
    public MetodoEnvio getMetodoEnvioById(int id) {
        Optional<MetodoEnvio> optional= metodoEnvioRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe metodoEnvio");
        }
    }

    @Override
    public void deleteMetodoEnvio(int id) {
        metodoEnvioRepository.deleteById(id);
    }

    @Override
    public boolean isMetodoEnvioExists(int id) {
        return metodoEnvioRepository.existsById(id);
    }

    @Override
    public List<MetodoEnvio> getAllMetodoEnvio() {
        return (List<MetodoEnvio>) metodoEnvioRepository.findAll();
    }

}
