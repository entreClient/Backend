package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Compra;

import java.util.List;

public interface CompraService {
    public abstract Compra createPago(Compra pago);
    public abstract void updatePago(Compra pago);
    public abstract Compra getPagoById(int id);
    public abstract void deletePago(int id);
    public abstract List<Compra> getAllPago();
    public abstract boolean isPagoExists(int id);
}
