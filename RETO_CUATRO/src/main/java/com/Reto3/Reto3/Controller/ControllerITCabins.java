package com.Reto3.Reto3.Controller;

import com.Reto3.Reto3.Model.TCabins;
import com.Reto3.Reto3.Services.ServiceCabins;
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
@RequestMapping("/api/Cabin/")
public class ControllerITCabins {
    
    @Autowired
    private ServiceCabins service;
    
    @GetMapping("/all")
    public List<TCabins> findAllCabins(){
        return service.getCabins();
    }
    
    @GetMapping("/Cabin/{id}")
    public TCabins findCabinsId(@PathVariable int id){
        return service.getCabinsById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addCabins(@RequestBody TCabins cabin){
        service.SaveCabins(cabin);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateCabins(@RequestBody TCabins cabin){
        service.updateCabins(cabin);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteCabins(@RequestBody TCabins cabin){
        service.deleteCabins(cabin.getId());
        return ResponseEntity.status(204).build();
    }

}
