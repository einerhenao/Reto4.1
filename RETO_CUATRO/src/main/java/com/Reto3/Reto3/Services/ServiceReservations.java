package com.Reto3.Reto3.Services;

import com.Reto3.Reto3.Model.TReservations;
import com.Reto3.Reto3.dao.ITReservations;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceReservations {
        
    @Autowired
    private ITReservations repository;
    
    public TReservations SaveReservations(TReservations reservation) {
       return repository.save(reservation);
    }
    
    public List<TReservations> getReservations(){
        return (List<TReservations>) repository.findAll();
    }
    
    public TReservations getReservationsById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    /*public TReservations getReservationsByName(String Name) {
        return repository.findByName(Name);
    }*/
    
    public String deleteReservations(int id) {
        repository.deleteById(id);
        return "Reservation remove" + id;
    }
    
    public TReservations updateReservations(TReservations reservation) {
        TReservations existingReservations = repository.findById(reservation.getIdReservation()).orElse(null);
        existingReservations.setStartDate(reservation.getStartDate());
        existingReservations.setDevolutionDate(reservation.getDevolutionDate());
        return repository.save(existingReservations);
    }
}
