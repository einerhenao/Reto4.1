
package com.Reto3.Reto3.Services;

import com.Reto3.Reto3.Model.TMessages;
import com.Reto3.Reto3.Model.TQualification_Res;
import com.Reto3.Reto3.dao.ITQualification_Res;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceQualification_Res {
    
    @Autowired
    private ITQualification_Res repository;
    
    public TQualification_Res SaveQualification_Res(TQualification_Res qua) {
       return repository.save(qua);
    }
    
    public List<TQualification_Res> getQualification_Res(){
        return (List<TQualification_Res>) repository.findAll();
    }
    
    public TQualification_Res getQualification_ResById(int id) {
        return repository.findById(id).orElse(null);
    }
    
   /* public TQualification_Res getQualification_ResByName(String Name) {
        return repository.findByName(Name);
    }*/
    
    public String deleteQualification_Res(int id) {
        repository.deleteById(id);
        return "Qualification remove" + id;
    }
    
    public TQualification_Res updateQualification_Res(TQualification_Res qua) {
        TQualification_Res existingQualification_Res = repository.findById(qua.getId()).orElse(null);
        existingQualification_Res.setQualification(qua.getQualification());
        existingQualification_Res.setMessage(qua.getMessage());
        return repository.save(existingQualification_Res);
    }
}
