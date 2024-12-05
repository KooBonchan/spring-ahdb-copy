package com.company.mapper;

import com.company.dto.MemberDTO;

public interface MemberMapper {
	
	MemberDTO login(MemberDTO memberDTO);
	
	int signup(MemberDTO memberDTO);
	int updatePermission(Long idx);
	int delete(Long idx);
}
