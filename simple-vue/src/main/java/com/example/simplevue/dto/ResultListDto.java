package com.example.simplevue.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultListDto extends ResponseDto {
    // 회원 리스트를 불러올 때 사용하는 dto
    private List<UserDto> userDtos;

    public ResultListDto(String code, String message, List<UserDto> userDtos) {
        super(code, message);
        this.userDtos = userDtos;
    }

    public ResultListDto(String code, String message) {
        super(code, message);
    }

    public static ResultListDto success(String message, List<UserDto> userDtos) {
        return new ResultListDto("200", message, userDtos);
    }

    public static ResultListDto badRequest() {
        return new ResultListDto("400", "Bad request.");
    }
}
