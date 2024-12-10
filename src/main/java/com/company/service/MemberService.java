package com.company.service;

import com.company.domain.MemberDTO;

public interface MemberService {
	public boolean login(MemberDTO memberDTO);
	
	public boolean signup(MemberDTO memberDTO);
	public boolean gainAdminPermission(Long idx);
	public boolean delete(Long idx);
}