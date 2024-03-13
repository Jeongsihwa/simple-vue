package com.example.simplevue.jpa;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class User3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String pwd;
    private Boolean gender = true;
    private Boolean del;
    private LocalDateTime dateTime;
}
