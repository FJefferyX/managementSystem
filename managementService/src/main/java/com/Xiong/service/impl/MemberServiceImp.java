package com.Xiong.service.impl;

import com.Xiong.dao.MemberDao;
import com.Xiong.domain.Member;
import com.Xiong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {
    @Autowired
    private MemberDao memberDao;

    @Override
    public Member findById(String id) {
        return null;
    }
}
