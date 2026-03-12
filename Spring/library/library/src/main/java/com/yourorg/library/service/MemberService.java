package com.yourorg.library.service;

import com.yourorg.library.entity.Member;
import java.util.List;

public interface MemberService {
    Member saveMember(Member member);
    List<Member> getAllMembers();
}