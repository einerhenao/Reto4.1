/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Representacion de la Tabla de la base de datos
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "message")
@Data

public class TMessages implements Serializable { //serializacion que convierte en bytes
    @Id //indica la persistencia de la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMessage")
    private int idMessage;
    @Column(name = "messageText", nullable = true, length = 250)//Not Null
    private String messageText;
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "cabin")//Se adiciona una columna mas que se va a llamar cabin
    @JsonIgnoreProperties({"messages","reservations"})
    private TCabins cabin;//Representa un obj de la tabla Tcabana
    @ManyToOne //Relacion de Muchos a Uno
    @JoinColumn(name = "client")//Se adiciona una columna mas que se va a llamar client
    @JsonIgnoreProperties({"messages","reservations"})
    private TClients client;//Representa un obj de la tabla Tcliente
}
