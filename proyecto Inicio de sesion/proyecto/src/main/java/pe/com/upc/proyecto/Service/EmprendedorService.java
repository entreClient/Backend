package com.upc.trabajo_final.Trabajo.Final.security.service;

import com.upc.trabajo_final.Trabajo.Final.security.model.Emprendedor;

import java.util.List;

public interface EmprendedorService {
    public abstract Emprendedor createEmprendedor(Emprendedor emprendedor);
    public abstract void updateEmprendedor(Emprendedor emprendedor);
    public abstract Emprendedor getEmprendedorById(int id);
    public abstract void deleteEmprendedor(int id);
    public abstract List<Emprendedor> getAllEmprendedor();
    public abstract boolean isEmprendedorExists(int id);

    public abstract Emprendedor findLastEmprendedorId();

}
