package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.MemberDTO;
import com.company.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public boolean login(MemberDTO memberDTO) {
		return memberMapper.login(memberDTO) != null;
	}

	@Override
	public boolean signup(MemberDTO memberDTO) {
		return memberMapper.signup(memberDTO) > 0;
	}

	@Override
	public boolean gainAdminPermission(Long idx) {
		return memberMapper.updatePermission(idx) > 0;
	}

	@Override
	public boolean delete(Long idx) {
		return memberMapper.delete(idx) > 0;
	}
	
}
