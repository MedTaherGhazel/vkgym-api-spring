package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.temporal.WeekFields;

@Data
@Entity
@Table(name = "weeks")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "program_id",nullable = false)
    private Long ProgramId;

}
