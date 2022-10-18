package com.Reto3.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Representacion de la Tabla de la base de datos
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "client")
@Data

public class TClients implements Serializable { //serializacion que convierte en bytes
    //private static final long serialVersionUID=1L;
    @Id //indica la persistencia de la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idClient")
    private int idClient;
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Column(name = "password", nullable = true, length = 45) //Null is ok
    private String password;
    @Column(name = "name", nullable = false, length = 250) //Not Null
    private String name;
    @Column(name = "age", nullable = true) //Null is ok
    private int age;
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "client")
    @JsonIgnoreProperties({"client"})
    //@OneToMany //Relacion de Muchos a Uno
    //@JoinColumn(name = "messages")//Se adiciona una columna mas que se va a llamar messages
    private List<TMessages> messages;//Representa un obj de la tabla Messages    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
   // @OneToMany //Relacion de Muchos a Uno
   // @JoinColumn(name = "reservations")//Se adiciona una columna mas que se va a llamar reservation
    private List<TReservations> reservations;//Representa un obj de la tabla Reservations
    
}
