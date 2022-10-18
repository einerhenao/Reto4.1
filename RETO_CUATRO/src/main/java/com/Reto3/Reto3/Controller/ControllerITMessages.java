package com.Reto3.Reto3.Controller;

import com.Reto3.Reto3.Model.TMessages;
import com.Reto3.Reto3.Services.ServiceMessages;
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
@RequestMapping("/api/Message/")
public class ControllerITMessages {
    
    @Autowired
    private ServiceMessages service;
    
    @GetMapping("/all")
    public List<TMessages> findAllMessages(){
        return service.getMessages();
    }
    
    @GetMapping("/Message/{id}")
    public TMessages findMessagesId(@PathVariable int id){
        return service.getMessagesById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addMessages(@RequestBody TMessages message){
        service.SaveMesagges(message);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateMessages(@RequestBody TMessages message){
        service.updateMessages(message);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteMessages(@RequestBody TMessages message){
        service.deleteMessages(message.getIdMessage());
        return ResponseEntity.status(204).build();
    }
}
