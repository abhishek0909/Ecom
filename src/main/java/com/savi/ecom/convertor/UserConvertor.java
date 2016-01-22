package com.savi.ecom.convertor;

import org.springframework.stereotype.Component;

import com.savi.ecom.dto.UserDTO;
import com.savi.ecom.model.UserModel;


public class UserConvertor implements IConvertor<UserModel, UserDTO> {

	public UserModel convert(UserDTO userDto) {
		
		UserModel user = new UserModel();
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user;
	}

}
