package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;

import java.util.List;

public interface MetodoPagoService {
    public abstract MetodoPago createMetodoPago(MetodoPago metodoPago);
    public abstract void updateMetodoPago(MetodoPago metodoPago);
    public abstract MetodoPago getMetodoPagoById(int id);
    public abstract void deleteMetodoPago(int id);
    public abstract List<MetodoPago> getAllMetodoPago();
    public abstract boolean isMetodoPagoExists(int id);
}
