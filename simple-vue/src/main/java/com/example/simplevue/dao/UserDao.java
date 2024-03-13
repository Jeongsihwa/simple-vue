package com.example.simplevue.dao;

import com.example.simplevue.dto.UserDto;

import java.util.List;

public interface UserDao {
    public List<UserDto> findAll();
    public int editById(UserDto userDto);
    public int delete(Integer id);
    public int save(UserDto userDto);
}
