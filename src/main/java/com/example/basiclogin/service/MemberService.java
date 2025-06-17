package com.example.basiclogin.service;

import com.example.basiclogin.domain.Member;
import com.example.basiclogin.dto.JoinRequest;
import com.example.basiclogin.dto.LoginRequest;
import com.example.basiclogin.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 로그인 ID 중복 검사 메서드
    public boolean checkLoginIdDuplicate(String loginId){
        return memberRepository.existsByLoginId(loginId);
    }

    // 회원가입 메서드
    public void join(JoinRequest joinRequest) {
        memberRepository.save(joinRequest.toEntity());
    }

    // 로그인 메서드
    public Member login(LoginRequest loginRequest) {
        Member findMember = memberRepository.findByLoginId(loginRequest.getLoginId());

        if(findMember == null){
            return null;
        }

        // 암호화된 비밀번호 (passwordEncoder) 를 사용할 시 이 코드를 사용해야 함
        if (!passwordEncoder.matches(loginRequest.getPassword(), findMember.getPassword())) {
            return null;
        }

        return findMember;
    }

    // 로그인한 Member 반환 메서드
    public Member getLoginMemberById(Long memberId){
        if(memberId == null) return null;

        Optional<Member> findMember = memberRepository.findById(memberId);
        return findMember.orElse(null);

    }
}
