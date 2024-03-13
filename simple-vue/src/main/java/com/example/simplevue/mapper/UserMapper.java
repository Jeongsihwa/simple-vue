package com.example.simplevue.mapper;

import com.example.simplevue.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<UserDto> findAll();

    @Update("update user3 set name = #{name}, pwd = #{pwd}, gender = #{gender} where id = #{id}")
    public int editById(UserDto userDto);

    @Update("update user3 set del = true where id = #{id}")
    public int delete(int id);

    @Insert("insert into user3 (name, email, pwd, gender, datetime) values (#{name}, #{email}, #{pwd}, #{gender}, now())")
    public int save(UserDto userDto);
}
