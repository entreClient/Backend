package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Producto;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CategoriaRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.EmprendimientoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.ProductoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto getProductoById(Integer id) {
        Optional<Producto> optional = productoRepository.findById(id);
        if (optional.isPresent()) {
            return  optional.get();
        }
        return null;
    }


    @Override
    public List<Producto> getAllProducto(){
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public boolean isProductoExists(int id){
        return productoRepository.existsById(id);
    }

}
