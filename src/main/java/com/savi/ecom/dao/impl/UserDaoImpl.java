package com.savi.ecom.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.savi.ecom.dao.UserDao;
import com.savi.ecom.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public void create(final UserModel model) {
		// TODO Auto-generated method stub
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con
                        .prepareStatement("INSERT into user(EMAIL,PASSWORD) VALUES (?, ?)");
              
                stmt.setString(1, model.getEmail());
                stmt.setString(2, model.getPassword());
                return stmt;
				
			}
		});
	}

	public void update(final UserModel model) {
		
   jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con
                        .prepareStatement("UPDATE user SET EMAIL= ? WHERE USERID=?");
                stmt.setString(2, model.getUserid());
                stmt.setString(1, model.getEmail());
              
                return stmt;
				
			}
		});
		
		
	}

	public void delete(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	public void modify(UserModel model) {
		// TODO Auto-generated method stub
		
	}

	public UserModel getCurrentUser(final String userid) {
		// TODO Auto-generated method stub
	List<UserModel> users =  jdbcTemplate.query(new PreparedStatementCreator() {

		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement stmt = con
                    .prepareStatement("select * from user where EMAIL=?");
          
			stmt.setString(1, userid);
          
            return stmt;
			}
		
       	}, new UserMapper());
		if(!CollectionUtils.isEmpty(users)){
			return users.get(0);
		}
		return null;
	}
	
	
	
	public UserModel findByEmailAddress(final String email) {
		// TODO Auto-generated method stub
		List<UserModel> users =  jdbcTemplate.query(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con
	                    .prepareStatement("select * from user where Email=?");
				stmt.setString(1, email);
				return stmt;
			}
		} , new UserMapper());
		if(!CollectionUtils.isEmpty(users)){
			return users.get(0);
		}
		return null;
	}
	
	private static final class UserMapper implements RowMapper<UserModel> {

	    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	UserModel actor = new UserModel();
	        
	    	actor.setPassword(rs.getString("password"));
	        actor.setEmail(rs.getString("email"));
	        return actor;
	    }
	}


}
