package com.example.simplevue.service;

import com.example.simplevue.dto.ResultDto;
import com.example.simplevue.dto.ResultListDto;
import com.example.simplevue.dto.UserDto;

public interface UserService {
    public ResultListDto findAll();
    public ResultDto editById(UserDto userDto);
    public ResultDto delete(Integer id);
    public ResultDto save(UserDto userDto);
}
