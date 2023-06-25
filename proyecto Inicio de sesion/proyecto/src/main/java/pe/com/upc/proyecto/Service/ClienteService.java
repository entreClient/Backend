package com.upc.trabajo_final.Trabajo.Final.security.service;

import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;

import java.util.List;

public interface ClienteService {
    public abstract Cliente createCliente(Cliente cliente);
    public abstract void updateCliente(Cliente cliente);
    public abstract Cliente getClienteById(int id);
    public abstract void deleteCliente(int id);
    public abstract List<Cliente> getAllCliente();
    public abstract boolean isClienteExists(int id);

}
