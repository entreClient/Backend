package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Yape;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.YapeRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.YapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YapeServiceImpl implements YapeService {
    @Autowired
    private YapeRepository yapeRepository;

    @Override
    public Yape createYape(Yape yape) {
        return yapeRepository.save(yape);
    }

    @Override
    public Yape updateYape(Yape yape) {
        return yapeRepository.save(yape);
    }

    @Override
    public void deleteYape(int id) {
        yapeRepository.deleteById(id);
    }

    @Override
    public Yape getYapeById(int id){
        Optional<Yape> optional = yapeRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException(" Yape not found for id :: " + id);
        }
    }

    @Override
    public List<Yape> getAllYape() {
        return (List<Yape>) yapeRepository.findAll();
    }

    @Override
    public boolean isYapeExists(int id) {
        return yapeRepository.existsById(id);
    }
}
