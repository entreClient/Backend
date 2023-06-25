package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Calificacion;

import java.util.List;

public interface CalificacionService {
    public abstract Calificacion createCalificacion(Calificacion calificacion);
    public abstract Calificacion updateCalificacion(Calificacion calificacion);
    public abstract void deleteCalificacion(int id);

    public abstract Calificacion getCalificacionById(int id);

    public abstract List<Calificacion> getAllCalificacion();
    public abstract boolean isCalificacionExists(int id);
}
