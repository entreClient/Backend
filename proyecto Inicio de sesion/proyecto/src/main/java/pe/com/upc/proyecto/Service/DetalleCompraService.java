package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.DetalleCompra;

import java.util.List;

public interface DetalleCompraService {
    public abstract DetalleCompra createDetallePago(DetalleCompra detalleProductoPago);
    public abstract void updateDetallePago(DetalleCompra detalleProductoPago);
    public abstract DetalleCompra getDetallePagoById(int id);
    public abstract void deleteDetallePago(int id);
    public abstract List<DetalleCompra> getAllDetallePago();
    public abstract boolean isDetallePagoExists(int id);
}
