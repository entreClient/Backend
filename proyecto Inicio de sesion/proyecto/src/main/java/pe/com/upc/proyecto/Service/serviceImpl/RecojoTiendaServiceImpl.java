package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.RecojoTienda;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.RecojoTiendaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.RecojoTiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecojoTiendaServiceImpl implements RecojoTiendaService {
    @Autowired
    private RecojoTiendaRepository recojoTiendaRepository;

    @Override
    public RecojoTienda createRecojoTienda(RecojoTienda recojoTienda){
        return recojoTiendaRepository.save(recojoTienda);
    }

    @Override
    public RecojoTienda updateRecojoTienda(RecojoTienda recojoTienda) {
        return recojoTiendaRepository.save(recojoTienda);
    }

    @Override
    public RecojoTienda getRecojoTiendaById(int id) {
        Optional<RecojoTienda> optional= recojoTiendaRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe recojoTienda");
        }
    }

    @Override
    public void deleteRecojoTienda(int id) {
        recojoTiendaRepository.deleteById(id);
    }

    @Override
    public boolean isRecojoTiendaExists(int id) {
        return recojoTiendaRepository.existsById(id);
    }

    @Override
    public List<RecojoTienda> getAllRecojoTienda() {
        return (List<RecojoTienda>) recojoTiendaRepository.findAll();
    }

}
