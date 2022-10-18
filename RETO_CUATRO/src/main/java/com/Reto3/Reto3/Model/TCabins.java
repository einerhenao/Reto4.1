
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

@Data
@Entity //Representacion de la Tabla de la base de datos
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "cabana")

public class TCabins implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")//Not Null por Default
    private int id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "brand", nullable = true, length = 45) //Null is ok
    private String brand;
    @Column(name = "rooms", nullable = false) //Not Null
    private int rooms;
    @Column(name = "description", nullable = true, length = 250)//Nul is ok
    private String description;
    @ManyToOne
    @JoinColumn(name="category", nullable = true)
    @JsonIgnoreProperties("cabins")
    private TCategory category;
    @OneToMany(cascade={CascadeType.PERSIST}, mappedBy="cabin")
    @JsonIgnoreProperties({"cabin","client"})//Relacion de Muchos a Uno
    //@JoinColumn(name = "messages", nullable = true)//Se adiciona una columna mas que se va a llamar messages
    private List<TMessages> messages;//Representa un obj de la tabla Messages
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="cabin")
    @JsonIgnoreProperties({"cabin","message"})//@JoinColumn(name = "reservations", nullable = true)//Se adiciona una columna mas que se va a llamar reservation
    private List<TReservations> reservations;//Representa un obj de la tabla Reservations
    
    
    }
