package com.example.basiclogin.dto;

import com.example.basiclogin.domain.Member;
import com.example.basiclogin.domain.MemberRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// 회원가입 시 데이터 받는 폼
public class JoinRequest {

    @NotBlank(message = "ID를 입력하세요.")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;

    @NotBlank(message = "비밀번호를 한번 더 입력하세요.")
    private String passwordCheck;

    @NotBlank(message = "이름을 입력하세요.")
    private String name;

    public Member toEntity(){
        return Member.builder()
                .loginId(this.loginId)
                .password(this.password)
                .name(this.name)
                .role(MemberRole.USER)
                .build();
    }
}
