package com.example.basiclogin.repository;

import com.example.basiclogin.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 로그인 ID를 갖는 객체가 존재하는지 => 존재하면 true 리턴 (ID 중복 검사 시 필요)
    boolean existsByLoginId(String loginId);

    // 로그인 ID를 갖는 객체 반환
    Member findByLoginId(String loginId);
}
