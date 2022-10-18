package com.Reto3.Reto3.dao;

import com.Reto3.Reto3.Model.TClients;
import org.springframework.data.repository.CrudRepository;

public interface ITClients extends CrudRepository<TClients, Integer> {

    public TClients findByName(String Name);
    
}
