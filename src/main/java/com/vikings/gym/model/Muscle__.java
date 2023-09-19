package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "muscles")
@Data
public class Muscle__ implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;     
    @Column(name = "description",nullable = false)
    private String description;
}
