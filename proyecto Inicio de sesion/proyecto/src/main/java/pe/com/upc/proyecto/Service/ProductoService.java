package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Producto;

import java.util.List;

public interface ProductoService {
    public abstract Producto createProducto(Producto producto);
    public abstract Producto updateProducto(Producto producto);
    //public abstract Producto getProductoById(int id);
    public abstract Producto getProductoById(Integer id);
    public abstract void deleteProducto(int id);
    public abstract List<Producto> getAllProducto();
    public abstract boolean isProductoExists(int id);
}
