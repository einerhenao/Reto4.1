package com.Reto3.Reto3.Controller;

import com.Reto3.Reto3.Model.TCategory;
import com.Reto3.Reto3.Services.ServiceCategory;
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
@RequestMapping("/api/Category/")

public class ControllerITCategory {
   
    @Autowired
    private ServiceCategory service;
    
    @GetMapping("/all")
    public List<TCategory> findAllCategory(){
        return service.getCategory();
    }
    
    @GetMapping("/Category/{id}")
    public TCategory findCategoryId(@PathVariable int id){
        return service.getCategoryById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addCategory(@RequestBody TCategory category){
        service.SaveCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateCategory(@RequestBody TCategory category){
        service.updateCategory(category);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteCategory(@RequestBody TCategory category){
        service.deleteCategory(category.getId());
        return ResponseEntity.status(204).build();
    }
}
