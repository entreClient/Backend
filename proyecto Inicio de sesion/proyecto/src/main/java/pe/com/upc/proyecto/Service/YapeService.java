package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Yape;

import java.util.List;

public interface YapeService {
    public abstract Yape createYape(Yape yape);
    public abstract Yape updateYape(Yape yape);
    public abstract Yape getYapeById(int id);
    public abstract void deleteYape(int id);
    public abstract List<Yape> getAllYape();
    public abstract boolean isYapeExists(int id);
}
