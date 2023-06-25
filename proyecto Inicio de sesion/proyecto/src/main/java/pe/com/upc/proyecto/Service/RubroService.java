package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Rubro;

import java.util.List;

public interface RubroService {
    public abstract Rubro createRubro(Rubro rubro);
    public abstract Rubro updateRubro(Rubro rubro);
    public abstract Rubro getRubroById(int id);
    public abstract void deleteRubro(int id);
    public abstract List<Rubro> getAllRubro();
    public abstract boolean isRubroExists(int id);
}
