package com.Reto3.Reto3.dao;

import com.Reto3.Reto3.Model.TCategory;
import org.springframework.data.repository.CrudRepository;

public interface ITCategory extends CrudRepository<TCategory, Integer> {

    //public TCategory findByName(String Name);
    
}
