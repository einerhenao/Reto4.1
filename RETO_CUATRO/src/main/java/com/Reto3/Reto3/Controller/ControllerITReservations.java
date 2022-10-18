package com.Reto3.Reto3.Controller;

import com.Reto3.Reto3.Model.TReservations;
import com.Reto3.Reto3.Services.ServiceReservations;
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
@RequestMapping("/api/Reservation/")
public class ControllerITReservations {
    
    @Autowired
    private ServiceReservations service;
    
    @GetMapping("/all")
    public List<TReservations> findAllReservations(){
        return service.getReservations();
    }
    
    @GetMapping("/Reservation/{id}")
    public TReservations findReservationsId(@PathVariable int id){
        return service.getReservationsById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addReservations(@RequestBody TReservations reservation){
        service.SaveReservations(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateReservations(@RequestBody TReservations reservation){
        service.updateReservations(reservation);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteReservations(@RequestBody TReservations reservation){
        service.deleteReservations(reservation.getIdReservation());
        return ResponseEntity.status(204).build();
    }
}
