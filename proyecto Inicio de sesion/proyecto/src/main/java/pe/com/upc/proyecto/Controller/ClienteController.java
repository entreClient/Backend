package pe.com.upc.proyecto.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.upc.proyecto.Entities.Cliente;
import pe.com.upc.proyecto.Service.ClienteServicio;

import java.security.PrivateKey;

public class ClienteController {
    @Autowired
    private ClienteServicio clienteServicio;

    @RequestMapping(value = "/cliente",method = RequestMethod.POST)
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente){
        cliente=clienteServicio.createCliente(cliente);
        return new ResponseEntity<>("Cliente creado", HttpStatus.CREATED);
    }
}
