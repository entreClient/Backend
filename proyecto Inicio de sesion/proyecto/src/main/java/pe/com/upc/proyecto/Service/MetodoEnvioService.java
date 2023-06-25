package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoEnvio;

import java.util.List;

public interface MetodoEnvioService {
    public abstract MetodoEnvio createMetodoEnvio(MetodoEnvio metodoEnvio);
    public abstract MetodoEnvio updateMetodoEnvio(MetodoEnvio metodoEnvio);
    public abstract void deleteMetodoEnvio(int id);
    public abstract MetodoEnvio getMetodoEnvioById(int id);
    public abstract List<MetodoEnvio> getAllMetodoEnvio();
    public abstract boolean isMetodoEnvioExists(int id);
}
