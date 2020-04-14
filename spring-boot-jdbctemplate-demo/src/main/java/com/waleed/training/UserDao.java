package com.waleed.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	
	@Autowired
	JdbcTemplate template;
	
	Integer getCountOfUsers() {
		return template.queryForObject("select count(*) from accounts", Integer.class);
	}
	
	String getUserName(String name) {
		return template.queryForObject(
				"select userId from accounts where userName = ?",
				new Object[] {name},
				String.class);
	}
	
	int createUser(User user) {
		return template.update("insert into accounts values(?,?,?)",new Object[] {user.getUserName(),user.getUserId(),user.getBalance()});
	}
	
	User getUser(String userId) {
		
		return template.queryForObject("select * from accounts where userId=?",new Object[] {userId},new BeanPropertyRowMapper<User>(User.class));
	}
	
	int updateUser(String userId,User user) {
		
		return 	template.update("update accounts set userName=? , balance=? where userId=?",new Object[] {user.getUserName(),user.getBalance(),userId});
	}
	
	int deleteUser(String userId) {
		return template.update("delete from accounts where userId=?",new Object[] {userId});
	}
	
	List<User> listOfUsers() {
		return template.query("select * from accounts",new BeanPropertyRowMapper<User>(User.class));
	}
}
