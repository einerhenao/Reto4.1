package com.Reto3.Reto3.Services;

import com.Reto3.Reto3.Model.TUsers;
import com.Reto3.Reto3.dao.ITUsers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsers {
       
    @Autowired
    private ITUsers repository;
    
    public TUsers SaveUsers(TUsers user) {
       return repository.save(user);
    }
    
    public List<TUsers> getUsers(){
        return (List<TUsers>) repository.findAll();
    }
    
    public TUsers getUsersById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public TUsers getUsersByName(String Name) {
        return repository.findByName(Name);
    }
    
    public String deleteUsers(int id) {
        repository.deleteById(id);
        return "User Admin remove" + id;
    }
    
    public TUsers updateUsers(TUsers user) {
        TUsers existingUsers = repository.findById(user.getId()).orElse(null);
        existingUsers.setEmail(user.getEmail());
        existingUsers.setName(user.getName());
        existingUsers.setPassword(user.getPassword());
        return repository.save(existingUsers);
    }
}
