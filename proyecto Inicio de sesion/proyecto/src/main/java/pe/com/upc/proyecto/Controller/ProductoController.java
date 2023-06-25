package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;


import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Producto;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CategoriaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.EmprendimientoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.ProductoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/entreclient/v1")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, EmprendimientoRepository emprendimientoRepository) {
        this.productoRepository = productoRepository;
    }

    //URL: http://localhost:8080/api/entreclient/v1/productos
    //Method: GET
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getAllProductos(){
        return new ResponseEntity<List<Producto>>(productoService.getAllProducto(), org.springframework.http.HttpStatus.OK);
    }


    //URL: http://localhost:8080/api/entreclient/v1/productos
    //Method: POST
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @PostMapping("/productos")
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto){
        validateProducto(producto);
        existsProductosByNombre(producto);
        return new ResponseEntity<Producto>(productoService.createProducto(producto), org.springframework.http.HttpStatus.CREATED);
    }

    private void validateProducto(Producto producto){
        if(producto.getNombre() == null || producto.getNombre().isEmpty()){
            throw new ValidationException("El nombre es obligatorio");
        }
        if(producto.getPrecioUnitario() == null || producto.getPrecioUnitario().compareTo(BigDecimal.ZERO) <= 0){
            throw new ValidationException("El precio es obligatorio y debe ser mayor a 0");
        }
        if(producto.getStock() == null || producto.getStock() <= 0){
            throw new ValidationException("El stock es obligatorio y debe ser mayor a 0");
        }
    }

    private void existsProductosByNombre(Producto producto){
        if(productoRepository.existsByNombre(producto.getNombre())){
            throw new ValidationException("Ya existe un producto con el nombre ingresado");
        }
    }

    //URL: http://localhost:8080/api/entreclient/v1/productos
    //Method: PUT
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @PutMapping("/productos")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
        return new ResponseEntity<Producto>(productoService.updateProducto(producto), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/productos
    //Method: DELETE
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable("id") int id, @RequestBody Producto producto){
        productoService.deleteProducto(id);
        return new ResponseEntity<Producto>(org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/entreclient/v1/productos/{id}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") int id){
        Producto producto = productoService.getProductoById(id);
        producto.setCategoria(producto.getCategoria()); // Obtener la categoría asociada al producto
        producto.setEmprendimiento(producto.getEmprendimiento()); // Obtener el emprendimiento asociado al producto

        return new ResponseEntity<Producto>(producto, org.springframework.http.HttpStatus.OK);
    }

}
