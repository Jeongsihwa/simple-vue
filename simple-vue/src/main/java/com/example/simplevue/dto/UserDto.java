package com.example.simplevue.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String pwd;
    private Boolean gender;
    private boolean del;
    private LocalDateTime dateTime;
}
