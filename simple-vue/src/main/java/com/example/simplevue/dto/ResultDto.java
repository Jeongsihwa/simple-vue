package com.example.simplevue.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ResultDto extends ResponseDto{
    private UserDto uDto;

    public ResultDto(String code, String message) {
        super(code, message);
    }

    public ResultDto(String code, String message, UserDto userDto) {
        super(code, message);
        this.uDto = userDto;
    }

    public static ResultDto successEdit(UserDto userDto){
        return new ResultDto("200","사용자 정보 수정 성공", userDto);
    }
    public static ResultDto successSave(){
        return new ResultDto("200","가입 성공");
    }
    public static ResultDto successDelete(){
        return new ResultDto("200","사용자 삭제");
    }
    public static ResultDto failEdit(){
        return new ResultDto("400","수정 실패");
    }
    public static ResultDto failDelete(){
        return new ResultDto("400","삭제 실패");
    }
    public static ResultDto failSave(){
        return new ResultDto("400","가입 실패");
    }
}
