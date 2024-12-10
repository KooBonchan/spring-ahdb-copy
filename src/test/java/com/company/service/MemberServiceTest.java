package com.company.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.domain.MemberDTO;
import com.company.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j2
public class MemberServiceTest {
	@Mock
	private MemberMapper mapper;
	@InjectMocks
	private MemberService memberService;
	
	private MemberDTO member;
	{
		member = new MemberDTO();
		member.setId("TESTIDMUSTBELENGTH20");
		member.setPassword("TESTpwd1234!@#$");
	}
	
	
	@Test
	public void testExists() {
		assertNotNull(memberService);
	}
	
	@Test
	public void testSignup() {
		when(mapper.signup(any(MemberDTO.class))).thenReturn(1);
		try {
			assertTrue("signup", memberService.signup(member));
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
}
