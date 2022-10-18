
package com.Reto3.Reto3.Controller;

import com.Reto3.Reto3.Model.TQualification_Res;
import com.Reto3.Reto3.Services.ServiceQualification_Res;
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
@RequestMapping("/api/Score/")
public class ControllerITQualification_Res {
    
    @Autowired
    private ServiceQualification_Res service;
    
    @GetMapping("/all")
    public List<TQualification_Res> findAllQualification_Res(){
        return service.getQualification_Res();
    }
    
    @GetMapping("/Score/{id}")
    public TQualification_Res findQualification_ResId(@PathVariable int id){
        return service.getQualification_ResById(id);
    }
    
    @PostMapping("/all")
    public ResponseEntity addQualification_Res(@RequestBody TQualification_Res qua){
        service.SaveQualification_Res(qua);
        return ResponseEntity.status(201).build();
    }
    
    @PutMapping("/all")
    public ResponseEntity updateQualification_Res(@RequestBody TQualification_Res qua){
        service.updateQualification_Res(qua);
        return ResponseEntity.status(201).build();
    }
    
    @DeleteMapping("/all")
    public ResponseEntity deleteQualification_Res(@RequestBody TQualification_Res qua){
        service.deleteQualification_Res(qua.getId());
        return ResponseEntity.status(204).build();
    }
}
