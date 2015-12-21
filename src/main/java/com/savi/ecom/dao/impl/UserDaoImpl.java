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
                        .prepareStatement("INSERT into user(USERID, EMAIL) VALUES (?, ?)");
                stmt.setString(1, model.getUserid());
                stmt.setString(2, model.getEmail());
              
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

	public UserModel getCurrentUser(String userid) {
		// TODO Auto-generated method stub
	List<UserModel> users =  jdbcTemplate.query(new UserIdPS(userid) , new UserMapper());
		if(!CollectionUtils.isEmpty(users)){
			return users.get(0);
		}
		return null;
	}
	
	private static final class UserIdPS implements PreparedStatementCreator {
		
		private String id;
		
		public UserIdPS(String userid) {
			id = userid;
		}

		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement stmt = con
                    .prepareStatement("select USERID, EMAIL from user where USERID=?");
          
			stmt.setString(1, id);
          
            return stmt;
		}
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
