package com.company.dto;

import lombok.Data;

@Data
public class MemberDTO {
	long idx;
	String id;
	String password;
	boolean admin;
}
