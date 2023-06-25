package com.upc.trabajo_final.Trabajo.Final.security.controller;

import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import com.upc.trabajo_final.Trabajo.Final.security.repository.ClienteRepository;
import com.upc.trabajo_final.Trabajo.Final.security.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/entreclient")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    @PostMapping("/clientes")
    public ResponseEntity<Object> createCliente(@RequestBody Cliente cliente){
        cliente= clienteService.createCliente(cliente);
        return new ResponseEntity<>("Cliente creado", HttpStatus.CREATED);
    }

    //URL: http://localhost:8080/api/v1/entreclient/clientes/{clienteId}
    //GET
    @Transactional
    @GetMapping("/{clienteId}")
    public Cliente obtenerClienteConMetodosPago(@PathVariable int clienteId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            return cliente;
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    //URL: http://localhost:8080/api/v1/entreclient/clientes
    //GET
    @Transactional(readOnly = true)
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return new ResponseEntity<List<Cliente>>(clienteService.getAllCliente(), HttpStatus.OK);
    }

}
