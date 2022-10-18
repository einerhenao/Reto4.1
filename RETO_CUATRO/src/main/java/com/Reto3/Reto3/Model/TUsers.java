/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //Representacion de la Tabla de la base de datos
@AllArgsConstructor
@NoArgsConstructor
@Table (name= "users_admin")
@Data

public class TUsers implements Serializable { //serializacion que convierte en bytes
    @Id //indica la persistencia de la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "email", nullable = true, length = 45) //Null is ok
    private String email;
    @Column(name = "name", nullable = false, length = 250) //Not Null
    private String name;
    @Column(name = "password", nullable = true, length = 45) //Null is ok
    private String password;
}