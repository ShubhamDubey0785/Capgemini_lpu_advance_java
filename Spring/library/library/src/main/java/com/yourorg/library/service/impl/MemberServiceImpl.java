package com.yourorg.library.service.impl;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.yourorg.library.service.MemberService;
import com.yourorg.library.repository.MemberRepository;
import com.yourorg.library.entity.Member;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepo;

    public Member saveMember(Member member) {
        return memberRepo.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }
}