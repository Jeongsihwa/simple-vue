package com.example.simplevue.service;

import com.example.simplevue.dao.UserDao;
import com.example.simplevue.dto.ResultDto;
import com.example.simplevue.dto.ResultListDto;
import com.example.simplevue.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserDao userDao;
    private ResultDto resultDto2;

    @Override
    public ResultListDto findAll() {
        ResultListDto resultDtos = ResultListDto.badRequest();
        List<UserDto> resultList = userDao.findAll();
        if (!resultList.isEmpty()) {
            resultDtos = ResultListDto.success("find all", resultList);
        }
        return resultDtos;
    }

    @Override
    public ResultDto editById(UserDto userDto) {
        int state = userDao.editById(userDto);
        ResultDto resultDto = ResultDto.failEdit();
        if(state == 1) return ResultDto.successEdit(userDto);
        return resultDto;
    }

    @Override
    public ResultDto delete(Integer id) {
        int state = userDao.delete(id);
        if(state == 1) return ResultDto.successDelete();
        return ResultDto.failDelete();
    }

    @Override
    public ResultDto save(UserDto userDto) {
        int state = userDao.save(userDto);
        if(state == 1) return ResultDto.successSave();
        return ResultDto.failSave();
    }
}
