package com.example.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
public class Bike {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "model")
    private String model;
}
