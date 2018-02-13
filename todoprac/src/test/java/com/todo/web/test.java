package com.todo.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.todo.mappers.TimeMapper;

import lombok.extern.java.Log;
@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
   locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class test {

	@Inject
	DataSource ds;
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		log.info("test");
	}

	@Test
	public void dbConnection() throws Exception{
		String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/won";
        String user = "won";
        String pw = "wonprac";
        
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pw);
        System.out.println(con);
        con.close();
	}
	
	@Test
	public void jdbcTest() throws SQLException {
		log.info(""+ds.getConnection());
	}
	
	
	@Inject
	TimeMapper mapper;
	
	@Test
	public void timeTest() {
		log.info(mapper.getTime());
	}
}
