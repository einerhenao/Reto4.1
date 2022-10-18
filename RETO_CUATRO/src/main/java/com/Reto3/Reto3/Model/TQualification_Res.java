package com.Reto3.Reto3.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity //Representacion de la Tabla de la base de datos
@Table (name= "qualifications_res")
@Data
public class TQualification_Res implements Serializable {
    @Id //indica la persistencia de la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "qualification", nullable = true)
    private int qualification;
    @Column(name = "message", nullable = true, length = 250)
    private String message; 
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "reservations")//Se adiciona una columna mas que se va a llamar messages
    private TReservations reservations;//Representa un obj de la tabla Messages
}
