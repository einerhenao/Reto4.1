package com.Reto3.Reto3.Services;

import com.Reto3.Reto3.Model.TCabins;
import com.Reto3.Reto3.dao.ITCabins;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCabins {
    
    @Autowired
    private ITCabins repository;
    
    public TCabins SaveCabins(TCabins cabin) {
       return repository.save(cabin);
    }
    
    public List<TCabins> getCabins(){
        return (List<TCabins>) repository.findAll();
    }
    
    public TCabins getCabinsById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public TCabins getCabinsByName(String Name) {
        return repository.findByName(Name);
    }
    
    public String deleteCabins(int id) {
        repository.deleteById(id);
        return "Cabin remove" + id;
    }
    
    public TCabins updateCabins(TCabins cabin) {
        TCabins existingCabins = repository.findById(cabin.getId()).orElse(null);
        existingCabins.setBrand(cabin.getBrand());
        existingCabins.setRooms(cabin.getRooms());
        existingCabins.setName(cabin.getName());
        existingCabins.setDescription(cabin.getDescription());
        return repository.save(existingCabins);
    }
}
