package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "days")
public class Day implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "name",nullable = false)
    private DayOfWeek day;
    @Column(name = "is_rest",nullable = false)
    private boolean restDay;
    @Column(name = "week_id",nullable = false)
    private String weekId;

}