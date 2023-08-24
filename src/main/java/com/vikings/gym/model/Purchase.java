package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "program_id",nullable = false)
    private Long programId;
    @Column(name = "price",nullable = false)
    private Double price;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
}
