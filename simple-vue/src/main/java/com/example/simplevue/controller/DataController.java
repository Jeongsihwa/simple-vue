package com.example.simplevue.controller;

import com.example.simplevue.dto.ResultDto;
import com.example.simplevue.dto.ResultListDto;
import com.example.simplevue.dto.UserDto;
import com.example.simplevue.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
public class DataController {
    private final UserService userService;
    @GetMapping("/")
    public String home(){
        return "Data 준비 중";
    }
    @GetMapping("/api")
    public String api(){
        return "Api Data 준비 중";
    }

    @GetMapping("/findAll")
    public ResultListDto findAll(){
        return userService.findAll();
    }

    @PostMapping("/editById")
    public ResultDto editById(@RequestBody UserDto userDto){
        return userService.editById(userDto);
    }
    @PostMapping("/save")
    public ResultDto save(@RequestBody UserDto userDto){
        log.info("userDto {}", userDto);
        return userService.save(userDto);
    }
    @DeleteMapping("/delete")
    public ResultDto delete(@RequestParam("id") int id){
        return userService.delete(id);
    }

}

