package pe.com.upc.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.upc.proyecto.Entities.Emprendedor;
import pe.com.upc.proyecto.Service.EmprendedorServicio;

public class EmprendedorController {
    @Autowired
    private EmprendedorServicio emprendedorServicio;
    @RequestMapping(value = "/emprendedor",method = RequestMethod.POST)
    public ResponseEntity<Object> createEmprendedor(@RequestBody Emprendedor emprendedor){
        emprendedor=emprendedorServicio.createEmprendedor(emprendedor);
        return new ResponseEntity<>("Emprendedor creado", HttpStatus.CREATED);
    }
}
