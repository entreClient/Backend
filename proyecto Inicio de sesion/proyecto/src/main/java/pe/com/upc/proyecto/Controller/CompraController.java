package com.upc.trabajo_final.Trabajo.Final.Entreclient.controller;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.exception.ValidationException;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoEnvio;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Compra;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.MetodoEnvioRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.MetodoPagoRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.CompraRepository;
import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import com.upc.trabajo_final.Trabajo.Final.security.repository.ClienteRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/v1/entreclient")
public class CompraController {
    @Autowired
    private CompraService compraService;

    private final CompraRepository compraRepository;

    private final ClienteRepository clienteRepository;
    private final MetodoPagoRepository metodoPagoRepository;

    private final MetodoEnvioRepository metodoEnvioRepository;

    public CompraController(CompraRepository compraRepository, ClienteRepository clienteRepository, MetodoPagoRepository metodoPagoRepository, MetodoEnvioRepository metodoEnvioRepository) {
        this.compraRepository = compraRepository;
        this.clienteRepository = clienteRepository;
        this.metodoPagoRepository = metodoPagoRepository;
        this.metodoEnvioRepository = metodoEnvioRepository;
    }

    //Url: http://localhost:8080/api/v1/entreclient/compras
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/compras")
    public ResponseEntity<List<Compra>> getAllPagos(){
        return new ResponseEntity<List<Compra>>(compraRepository.findAll(), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/entreclient/compras/{id}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/compras/{id}")
    public ResponseEntity<String> getMetodosPagoAndClienteByPagoId(@PathVariable("id") Integer compraId) {
        Cliente cliente = compraRepository.findClienteByCompraId(compraId);
        MetodoPago metodoPago = compraRepository.findMetodoPagoByCompraId(compraId);
        MetodoEnvio metodoEnvio = compraRepository.findMetodoEnvioByCompraId(compraId);
        Compra pago = compraRepository.findById(compraId).orElse(null);
        if (cliente != null && metodoPago != null && metodoEnvio != null && pago != null) {
            StringBuilder response = new StringBuilder();
            response.append("Pago: ").append(pago.getId()).append("\n");
            response.append("Cliente: ").append(cliente.getNombre()).append("\n");
            response.append("Métodos de pago:\n").append(metodoPago.getType()).append("\n");
            response.append("Métodos de envío:\n").append(metodoEnvio.getType()).append("\n");
            return new ResponseEntity<>(response.toString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró la información solicitada", HttpStatus.NOT_FOUND);
        }
    }

    //URL: http://localhost:8080/api/v1/compras
    //Method: POST
    @Transactional(readOnly = true)
    @PostMapping("/compras")
    public ResponseEntity<Compra> createPago(@RequestBody Compra compra) {
        // Buscar el cliente por su ID
        Cliente cliente = clienteRepository.findById(compra.getCliente().getId())
                .orElseThrow(() -> new ValidationException("No se encontró el cliente con el ID proporcionado"));

        // Crear el objeto Pago y asignar el cliente y el método de pago
        compra = new Compra();
        compra.setFecha(LocalDate.now());
        compra.setCliente(cliente);
        compra.setMetodoPago(metodoPagoRepository.findById(compra.getMetodoPago().getId())
                .orElseThrow(() -> new ValidationException("No se encontró el método de pago con el ID proporcionado")));
        compra.setMetodoEnvio(metodoEnvioRepository.findById(compra.getMetodoEnvio().getId())
                .orElseThrow(() -> new ValidationException("No se encontró el método de envío con el ID proporcionado")));
        validatePago(compra);
        compra.setFecha(LocalDate.now());
        return new ResponseEntity<Compra>(compraService.createPago(compra), org.springframework.http.HttpStatus.CREATED);
    }

    private void validatePago(Compra pago) {
        if (pago.getFecha() == null) {
            throw new ValidationException("Ingrese la fecha del pago");
        }
    }

    //URL: http://localhost:8080/api/v1/compras/{id}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/compras/{id}")
    public ResponseEntity<Compra> getPagoById(@Param("id") int id, @RequestBody Compra compra){
        return new ResponseEntity<Compra>(compraRepository.findById(id).orElseThrow(() -> new ValidationException("No existe el pago")), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/compras/{id}
    //Method: PUT
    @Transactional
    @PutMapping("/compras/{id}")
    public ResponseEntity<Compra> updatePago(@PathVariable("id") int id, @RequestBody Compra pago){
        Compra pagoDB = compraRepository.findById(id).orElseThrow(() -> new ValidationException("No existe el pago"));
        pagoDB.setFecha(pago.getFecha());
        return new ResponseEntity<Compra>(compraRepository.save(pagoDB), org.springframework.http.HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/v1/compras/{id}
    //Method: DELETE
    @Transactional
    @DeleteMapping("/compras/{id}")
    public ResponseEntity<Compra> deletePago(@PathVariable("id") int id){
        Compra pagoDB = compraRepository.findById(id).orElseThrow(() -> new ValidationException("No existe el pago"));
        compraRepository.delete(pagoDB);
        return new ResponseEntity<Compra>(pagoDB, org.springframework.http.HttpStatus.OK);
    }

}
