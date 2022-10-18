/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table (name= "category")
@Data

public class TCategory implements Serializable { //serializacion que convierte en bytes
    //private static final long serialVersionUID=1L;
    @Id //indica la persistencia de la PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "name", nullable = true, length = 45)//Not null
    private String name;
    @Column(name = "description", nullable = true, length = 250)// Null is ok
    private String description;
   // @OneToMany
    //@JoinColumn(name="cabins")
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties({"category"})
    private List<TCabins> cabins;
}
