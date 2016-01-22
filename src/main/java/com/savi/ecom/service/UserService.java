package com.savi.ecom.service;


import com.savi.ecom.dto.UserDTO;
import com.savi.ecom.model.UserModel;
import com.savi.ecom.user.api.LoginRequest;

public interface UserService {

	public boolean login(LoginRequest lr);
	
	public UserModel createUser(UserDTO userDTO);

	public boolean validateEmail(String email);
	
}
