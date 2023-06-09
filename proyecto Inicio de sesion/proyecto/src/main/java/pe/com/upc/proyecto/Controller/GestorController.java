package pe.com.upc.proyecto.Controller;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.upc.proyecto.Entities.Gestor;
import pe.com.upc.proyecto.Service.GestorServicio;

import java.util.List;
@RestController
public class GestorController {

    @Autowired
    private GestorServicio gestorServicio;
    @RequestMapping(value = "/gestor",method = RequestMethod.POST)
    public ResponseEntity<Object> createGestor(@RequestBody Gestor gestor){
        gestor=gestorServicio.createGestor(gestor);
        return new ResponseEntity<>("Usuario almacenado", HttpStatus.CREATED);
    }
    @RequestMapping(value = "/gestores",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllGestor(){
        List<Gestor> gestorList=gestorServicio.getAllGestor();
        if(gestorList.isEmpty()){
            return new ResponseEntity<>("",HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(gestorList,HttpStatus.OK);
        }
    }

}
