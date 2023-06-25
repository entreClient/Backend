package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Categoria;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CategoriaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entreclient/v1")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/categorias
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        return new ResponseEntity<List<Categoria>>(categoriaService.getAllCategoria(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/categorias
    //Method: POST
    @org.springframework.transaction.annotation.Transactional
    @PostMapping("/categorias")
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria){
        existsCategoriaByNombre(categoria);
        validateCategoria(categoria);
        return new ResponseEntity<Categoria>(categoriaService.createCategoria(categoria), org.springframework.http.HttpStatus.CREATED);
    }

    private void existsCategoriaByNombre(Categoria categoria){
        if(categoriaRepository.existsByNombre(categoria.getNombre())){
            throw new ValidationException("Ya existe una categoria con ese nombre");
        }
    }

    private void validateCategoria(Categoria categoria){
        if(categoria.getNombre().length() > 50){
            throw new ValidationException("El nombre de la categoria no puede tener mas de 50 caracteres");
        }
        if(categoria.getNombre().equals(" ") || categoria.getNombre().isEmpty()){
            throw new ValidationException("El nombre de la categoria no puede estar vacio");
        }
    }

    //URL: http://localhost:8080/api/entreclient/v1/categorias/{id}
    //Method: PUT
    @org.springframework.transaction.annotation.Transactional
    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable("id") int categoriaId, @RequestBody Categoria categoria){
        Categoria currentCategoria = categoriaRepository.findById(categoriaId).orElse(null);
        return new ResponseEntity<Categoria>(categoriaService.updateCategoria(currentCategoria), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/categorias/{id}
    //Method: DELETE
    @org.springframework.transaction.annotation.Transactional
    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Categoria> deleteCategoria(@PathVariable("id") int categoriaId){
        categoriaService.deleteCategoria(categoriaId);
        return new ResponseEntity<Categoria>(org.springframework.http.HttpStatus.NO_CONTENT);
    }

    //URL: http://localhost:8080/api/entreclient/v1/categorias/{id}
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable("id") int categoriaId){
        return new ResponseEntity<Categoria>(categoriaService.getCategoriaById(categoriaId), org.springframework.http.HttpStatus.OK);
    }
}
