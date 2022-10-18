package com.Reto3.Reto3.Services;


import com.Reto3.Reto3.Model.TMessages;
import com.Reto3.Reto3.dao.ITMessages;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMessages {
       
    @Autowired
    private ITMessages repository;
    
    public TMessages SaveMesagges(TMessages message) {
       return repository.save(message);
    }
    
    public List<TMessages> getMessages(){
        return (List<TMessages>) repository.findAll();
    }
    
    public TMessages getMessagesById(int id) {
        return repository.findById(id).orElse(null);
    }
    
   /* public TMessages getMessagesByName(String Name) {
        return repository.findByName(Name);
    }*/
    
    public String deleteMessages(int id) {
        repository.deleteById(id);
        return "Message remove" + id;
    }
    
    public TMessages updateMessages(TMessages message) {
        TMessages existingMessages = repository.findById(message.getIdMessage()).orElse(null);
        existingMessages.setMessageText(message.getMessageText());
        return repository.save(existingMessages);
    }
}
