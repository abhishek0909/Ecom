package com.savi.ecom.dao;

import com.savi.ecom.model.UserModel;

public interface UserDao extends ModelDao<UserModel>{

 public UserModel getCurrentUser(String userid);

public UserModel findByEmailAddress(String email);
	
	
}
