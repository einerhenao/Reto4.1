package com.Reto3.Reto3.dao;

import com.Reto3.Reto3.Model.TCabins;
import org.springframework.data.repository.CrudRepository;


public interface ITCabins extends CrudRepository<TCabins, Integer> {

    public TCabins findByName(String Name);
    
}
