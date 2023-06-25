package com.upc.trabajo_final.Trabajo.Final.security.service;

import com.upc.trabajo_final.Trabajo.Final.security.model.Gestor;

import java.util.List;

public interface GestorService {
    public abstract Gestor createGestor(Gestor gestor);
    public abstract void updateGestor(Gestor gestor);
    public abstract Gestor getGestorById(int id);
    public abstract void deleteGestor(int id);
    public abstract List<Gestor> getAllGestor();
    public abstract boolean isGestorExists(int id);

    public abstract Gestor findLastGestor();
}
