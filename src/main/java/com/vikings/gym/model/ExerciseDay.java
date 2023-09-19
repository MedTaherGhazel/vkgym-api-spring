package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ex_day")
@Data
public class ExerciseDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "day_id",nullable = false)
    private String dayId;
    @Column(name = "ex_id",nullable = false)
    private String exerciseId;
}
