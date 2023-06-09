package pe.com.upc.proyecto.Service;

import pe.com.upc.proyecto.Entities.Cliente;
import pe.com.upc.proyecto.Entities.Emprendimiento;

import java.util.List;

public interface ClienteServicio {

    public abstract Cliente createCliente(Cliente cliente);
    public abstract void updateCliente(Cliente cliente);
    public abstract Cliente getClienteById(int id);
    public abstract void deleteCliente(int id);
    public abstract List<Cliente> getAllCliente();
    public abstract boolean isClienteExists(int id);

}
