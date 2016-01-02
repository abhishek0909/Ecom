package com.savi.ecom.convertor;

import com.savi.ecom.dto.UserDTO;
import com.savi.ecom.model.UserModel;

public class UserConvertor {
	
	public UserModel convert(UserModel user, UserDTO userDto){
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		return user;
	}

}
