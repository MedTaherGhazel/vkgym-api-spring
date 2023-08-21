package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "programs")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false,length = 100)
    private String name;
    @Column(name = "description",nullable = false,length = 100)
    private String description;
    @Column(name = "is_free",nullable = false)
    private boolean isFree;
    @Column(name = "price")
    private Double price;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
}
