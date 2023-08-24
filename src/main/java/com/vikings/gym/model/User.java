package com.vikings.gym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username",unique = true,nullable = false,length = 100)
    private String username;
    @Column(name = "name",unique = true,nullable = false,length = 100)
    private String name;
    @Column( name = "password",nullable = false,length = 100)
    private String password;
    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "role",nullable = false)
    private Role role;
    @Transient
    private String token;

}
