package pe.com.upc.proyecto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.upc.proyecto.Entities.Emprendimiento;
import pe.com.upc.proyecto.Service.EmprendimientoServicio;

public class EmprendimientoController {
    @Autowired
    private EmprendimientoServicio emprendimientoServicio;
    @RequestMapping(value = "/emprendimiento",method = RequestMethod.POST)
    public ResponseEntity<Object> createEmprendedor(@RequestBody Emprendimiento emprendimiento){
        emprendimiento=emprendimientoServicio.createEmprendimiento(emprendimiento);
        return new ResponseEntity<>("Emprendimiento creado", HttpStatus.CREATED);
    }
}
