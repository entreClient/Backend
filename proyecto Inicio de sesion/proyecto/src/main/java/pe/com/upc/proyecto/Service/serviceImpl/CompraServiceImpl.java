package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Compra;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CompraRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {
    @Autowired
    private CompraRepository pagoRepository;

    @Override
    public Compra createPago(Compra pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public void updatePago(Compra pago){
        pagoRepository.save(pago);
    }

    @Override
    public void deletePago(int id){
        pagoRepository.deleteById(id);
    }

    @Override
    public Compra getPagoById(int id){
        Optional<Compra> optional = pagoRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException("Pago not found for id :: " + id);
        }
    }

    @Override
    public boolean isPagoExists(int id){
        return pagoRepository.existsById(id);
    }

    @Override
    public List<Compra> getAllPago(){
        return (List<Compra>) pagoRepository.findAll();
    }

}
