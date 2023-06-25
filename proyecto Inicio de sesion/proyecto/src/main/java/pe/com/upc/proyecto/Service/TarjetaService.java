package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Tarjeta;

import java.util.List;

public interface TarjetaService {
    public abstract Tarjeta createTarjeta(Tarjeta tarjeta);
    public abstract Tarjeta updateTarjeta(Tarjeta tarjeta);
    public abstract Tarjeta getTarjetaById(int id);
    public abstract void deleteTarjeta(int id);
    public abstract List<Tarjeta> getAllTarjeta();
    public abstract boolean isTarjetaExists(int id);
}
