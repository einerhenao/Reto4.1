package com.Reto3.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Representacion de la Tabla de la base de datos
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "reservation")
@Data

public class TReservations implements Serializable { //serializacion que convierte en bytes
    @Id //indica la persistencia de la PK
    @GeneratedValue
    @Column(name="idReservation")
    private int idReservation;
    @Column(name = "startDate", nullable = true)//Not Null
    private Date startDate;
    @Column(name = "devolutionDate", nullable = true)//Not Null
    private Date devolutionDate;
    @Column(name = "status", nullable = true)//Not Null
    private String status= "created";
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "cabin")//Se adiciona una columna mas que se va a llamar client
    @JsonIgnoreProperties("reservations")
    private TCabins cabin;//Representa un obj de la tabla Tcliente
    
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "client")//Se adiciona una columna mas que se va a llamar client
    @JsonIgnoreProperties({"reservations","messages"})
    private TClients client;//Representa un obj de la tabla Tcliente 

    
    
    //@OneToOne(cascade={CascadeType.REMOVE},mappedBy="reservation")
    //@JsonIgnoreProperties("reservation")
    
    
    @Column(name = "score", nullable = true)//Not Null
    private String score;
}