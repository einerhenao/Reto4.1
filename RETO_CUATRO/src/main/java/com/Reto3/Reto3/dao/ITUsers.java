package com.Reto3.Reto3.dao;

import com.Reto3.Reto3.Model.TUsers;
import org.springframework.data.repository.CrudRepository;

public interface ITUsers extends CrudRepository<TUsers, Integer> {

    public TUsers findByName(String Name);
    
}
