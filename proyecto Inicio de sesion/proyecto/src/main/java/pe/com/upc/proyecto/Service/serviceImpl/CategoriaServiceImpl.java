package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Categoria;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CategoriaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria getCategoriaById(int id) {
        Optional<Categoria> optional = categoriaRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Categoria not found for id :: " + id);
        }
    }

    @Override
    public void deleteCategoria(int id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public List<Categoria> getAllCategoria() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public boolean isCategoriaExists(int id) {
        return categoriaRepository.existsById(id);
    }

}
