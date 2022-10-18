package com.Reto3.Reto3.Controller;


import com.Reto3.Reto3.Model.TClients;
import com.Reto3.Reto3.Services.ServiceClients;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/Client/")
public class ControllerITClients {
 
    @Autowired
    private ServiceClients service;
    
    @GetMapping("/all")
    public List<TClients> findAllClients(){
        return service.getClients();
    }
    
    @GetMapping("/Client/{id}")
    public TClients findClientsId(@PathVariable int id){
        return service.getClientsById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addClients(@RequestBody TClients client){
        service.SaveClients(client);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateClients(@RequestBody TClients client){
        service.updateClients(client);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteClients(@RequestBody TClients client){
        service.deleteClients(client.getIdClient());
        return ResponseEntity.status(204).build();
    }
}
