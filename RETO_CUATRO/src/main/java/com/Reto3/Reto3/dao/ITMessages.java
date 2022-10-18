package com.Reto3.Reto3.dao;

import com.Reto3.Reto3.Model.TMessages;
import org.springframework.data.repository.CrudRepository;

public interface ITMessages extends CrudRepository<TMessages, Integer> {

    //public TMessages findByName(String Name);
    
}
