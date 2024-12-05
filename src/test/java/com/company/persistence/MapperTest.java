package com.company.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.dto.MemberDTO;
import com.company.mapper.MemberMapper;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
@Log4j2
public class MapperTest {
	@Autowired
	private MemberMapper memberMapper;
	
	static final String TEST_ID = "TESTIDMUSTBELENGTH20";
	static final String TEST_PASSWORD = "TESTpwd1234!@#$";
	
	@Test
	public void testMember() {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(TEST_ID);
		memberDTO.setPassword(TEST_PASSWORD);
		try {
			int result = memberMapper.signup(memberDTO);
			assertTrue(result > 0);
			
			long idx = memberDTO.getIdx();
			assertNotNull(memberMapper.login(memberDTO));
			
			result = memberMapper.delete(idx);
			assertTrue(result > 0);
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
}
