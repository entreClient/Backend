package com.upc.trabajo_final.Trabajo.Final.Entreclient.service;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Emprendimiento;

import java.util.List;

public interface EmprendimientoService {
    public abstract Emprendimiento createEmprendimiento(Emprendimiento emprendimiento);
    public abstract Emprendimiento updateEmprendimiento(Emprendimiento emprendimiento);
    public abstract Emprendimiento getEmprendimientoById(int id);
    public abstract void deleteEmprendimiento(int id);
    public abstract List<Emprendimiento> getAllEmprendimiento();
    public abstract boolean isEmprendimientoExists(int id);
}
