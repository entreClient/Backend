package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Delivery;

import java.util.List;

public interface DeliveryService {
    public abstract Delivery createDelivery(Delivery delivery);
    public abstract Delivery updateDelivery(Delivery delivery);
    public abstract void deleteDelivery(int id);

    public abstract Delivery getDeliveryById(int id);

    public abstract List<Delivery> getAllDelivery();
    public abstract boolean isDeliveryExists(int id);
}
