package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.RecojoTienda;

import java.util.List;

public interface RecojoTiendaService {
    public abstract RecojoTienda createRecojoTienda(RecojoTienda recojoTienda);
    public abstract RecojoTienda updateRecojoTienda(RecojoTienda recojoTienda);
    public abstract void deleteRecojoTienda(int id);
    public abstract RecojoTienda getRecojoTiendaById(int id);
    public abstract List<RecojoTienda> getAllRecojoTienda();
    public abstract boolean isRecojoTiendaExists(int id);
}
