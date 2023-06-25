package com.upc.trabajo_final.Trabajo.Final.security.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import com.upc.trabajo_final.Trabajo.Final.security.repository.ClienteRepository;
import com.upc.trabajo_final.Trabajo.Final.security.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente createCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public Cliente getClienteById(int id) {
        Optional<Cliente> optional= clienteRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe Emprendedor");
        }
    }

    @Override
    public void deleteCliente(int id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> getAllCliente() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public boolean isClienteExists(int id) {
        return clienteRepository.existsById(id);
    }
}
