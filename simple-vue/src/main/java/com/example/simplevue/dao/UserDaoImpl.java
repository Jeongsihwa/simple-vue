package com.example.simplevue.dao;

import com.example.simplevue.dto.UserDto;
import com.example.simplevue.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userMapper.findAll();
    }

    @Override
    public int editById(UserDto userDto) {
        return userMapper.editById(userDto);

    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public int save(UserDto userDto) {
        return userMapper.save(userDto);
    }
}
