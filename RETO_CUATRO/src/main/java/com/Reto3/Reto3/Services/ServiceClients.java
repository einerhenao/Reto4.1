package com.Reto3.Reto3.Services;

import com.Reto3.Reto3.Model.TClients;
import com.Reto3.Reto3.dao.ITClients;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClients {
        
    @Autowired
    private ITClients repository;
    
    public TClients SaveClients(TClients client) {
       return repository.save(client);
    }
    
    public List<TClients> getClients(){
        return (List<TClients>) repository.findAll();
    }
    
    public TClients getClientsById(int id) {
        return repository.findById(id).orElse(null);
    }
    
    public TClients getClientsByName(String Name) {
        return repository.findByName(Name);
    }
    
    public String deleteClients(int id) {
        repository.deleteById(id);
        return "Client remove" + id;
    }
    
    public TClients updateClients(TClients client) {
        TClients existingClients = repository.findById(client.getIdClient()).orElse(null);
        existingClients.setName(client.getName());
        existingClients.setEmail(client.getEmail());
        existingClients.setPassword(client.getPassword());
        existingClients.setAge(client.getAge());
        return repository.save(existingClients);
    }
}
