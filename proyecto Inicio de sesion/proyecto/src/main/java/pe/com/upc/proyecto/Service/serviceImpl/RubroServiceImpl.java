package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Rubro;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.RubroRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubroServiceImpl implements RubroService {
    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public Rubro createRubro(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    @Override
    public Rubro updateRubro(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    @Override
    public Rubro getRubroById(int id) {
        Optional<Rubro> optional = rubroRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new RuntimeException("Rubro not found for id: " + id);
        }

    }

    @Override
    public void deleteRubro(int id) {
        rubroRepository.deleteById(id);
    }

    @Override
    public List<Rubro> getAllRubro() {
        return (List<Rubro>) rubroRepository.findAll();
    }

    @Override
    public boolean isRubroExists(int id){
        return rubroRepository.existsById(id);
    }

}
