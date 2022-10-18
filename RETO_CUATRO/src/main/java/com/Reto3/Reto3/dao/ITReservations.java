package com.Reto3.Reto3.dao;

import com.Reto3.Reto3.Model.TReservations;
import org.springframework.data.repository.CrudRepository;

public interface ITReservations extends CrudRepository<TReservations, Integer> {

    //public TReservations findByName(String Name);
    
}
