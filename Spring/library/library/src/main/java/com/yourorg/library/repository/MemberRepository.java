package com.yourorg.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yourorg.library.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}