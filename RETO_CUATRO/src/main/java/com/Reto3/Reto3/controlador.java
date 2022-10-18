package com.Reto3.Reto3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controlador {
    
    @GetMapping("/einer")
    
        public String MensajeInicial(){
            
            return "Estoy dentro de la ruta Einer";
        }
}
