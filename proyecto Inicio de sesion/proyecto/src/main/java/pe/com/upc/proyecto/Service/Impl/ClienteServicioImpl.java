package pe.com.upc.proyecto.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.upc.proyecto.Entities.Cliente;
import pe.com.upc.proyecto.Entities.Emprendedor;
import pe.com.upc.proyecto.Repository.ClienteRepository;
import pe.com.upc.proyecto.Service.ClienteServicio;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {
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
