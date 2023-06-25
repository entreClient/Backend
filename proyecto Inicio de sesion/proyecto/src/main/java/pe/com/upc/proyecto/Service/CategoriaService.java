package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Categoria;

import java.util.List;

public interface CategoriaService {
    public abstract Categoria createCategoria(Categoria categoria);
    public abstract Categoria updateCategoria(Categoria categoria);
    public abstract Categoria getCategoriaById(int id);
    public abstract void deleteCategoria(int id);
    public abstract List<Categoria> getAllCategoria();
    public abstract boolean isCategoriaExists(int id);
}
