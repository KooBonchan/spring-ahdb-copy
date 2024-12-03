package com.company.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;



import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTests {
	@Test
	public void testConnection() {
		try(Connection connection = DriverManager.getConnection(
				"jdbc:log4jdbc:mysql://localhost:3306/arkham",
				"kbc", "12345")){
			log.info("Connection Success");
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
