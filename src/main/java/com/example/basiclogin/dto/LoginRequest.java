package com.example.basiclogin.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// 로그인 시 데이터 받는 폼
public class LoginRequest {

    private String loginId;
    private String password;
}
