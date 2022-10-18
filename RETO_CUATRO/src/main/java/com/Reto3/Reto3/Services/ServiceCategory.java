package com.Reto3.Reto3.Services;

import com.Reto3.Reto3.Model.TCategory;
import com.Reto3.Reto3.dao.ITCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCategory {
        
    @Autowired
    private ITCategory repository;
    
    public TCategory SaveCategory(TCategory category) {
       return repository.save(category);
    }
    
    public List<TCategory> getCategory(){
        return (List<TCategory>) repository.findAll();
    }
    
    public TCategory getCategoryById(int id) {
        return repository.findById(id).orElse(null);
    }
    
   /* public TCategory getCategoryByName(String Name) {
        return repository.findByName(Name);
    }*/
    
    public String deleteCategory(int id) {
        repository.deleteById(id);
        return "Categoty remove" + id;
    }
    
    public TCategory updateCategory(TCategory category) {
        TCategory existingCategory = repository.findById(category.getId()).orElse(null);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        return repository.save(existingCategory);
    }
}

