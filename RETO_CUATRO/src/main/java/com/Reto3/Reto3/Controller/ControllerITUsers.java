package com.Reto3.Reto3.Controller;

import com.Reto3.Reto3.Model.TUsers;
import com.Reto3.Reto3.Services.ServiceUsers;
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
@RequestMapping("/api/Admin/")
public class ControllerITUsers {
    
    @Autowired
    private ServiceUsers service;
    
    @GetMapping("/all")
    public List<TUsers> findAllUsers(){
        return service.getUsers();
    }
    
    @GetMapping("/Admin/{id}")
    public TUsers findUsersId(@PathVariable int id){
        return service.getUsersById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addUsers(@RequestBody TUsers user){
        service.SaveUsers(user);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateUsers(@RequestBody TUsers user){
        service.updateUsers(user);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteUsers(@RequestBody TUsers user){
        service.deleteUsers(user.getId());
          return ResponseEntity.status(204).build();
    }
}
