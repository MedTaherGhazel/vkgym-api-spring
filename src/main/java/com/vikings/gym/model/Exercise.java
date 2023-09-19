package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "exercises")
public class Exercise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description",nullable = false)
    private String description;
    @Column(name = "url",nullable = false)
    private String url;
    @Enumerated(EnumType.STRING)
    @Column(name = "muscle_prim_id",nullable = false)
    private Muscle musclePrimId;
    @Enumerated(EnumType.STRING)
    @Column(name = "muscle_sec_id",nullable = false)
    private Muscle muscleSecId;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

}
