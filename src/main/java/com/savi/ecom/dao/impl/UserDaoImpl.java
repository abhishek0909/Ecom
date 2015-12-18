package com.savi.ecom.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.savi.ecom.dao.UserDao;
import com.savi.ecom.model.UserModel;

public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public void create(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	public void update(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	public void delete(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	public void modify(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	public UserModel getCurrentUser(String userid) {
		// TODO Auto-generated method stub
		List<UserModel> users =  jdbcTemplate.query("select * from user", new UserMapper());
		
		return users.get(1);
	}
	
	private static final class UserMapper implements RowMapper<UserModel> {

	    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	UserModel actor = new UserModel();
	        actor.setUserid(rs.getString("userid"));
	        actor.setEmail(rs.getString("email"));
	        return actor;
	    }
	}

}
