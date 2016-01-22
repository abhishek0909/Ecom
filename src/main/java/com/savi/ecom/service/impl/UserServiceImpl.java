package com.savi.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savi.ecom.convertor.UserConvertor;
import com.savi.ecom.domain.repo.UserRepository;
import com.savi.ecom.dto.UserDTO;
import com.savi.ecom.exception.AuthenticationException;
import com.savi.ecom.exception.DuplicateUserException;
import com.savi.ecom.model.UserModel;
import com.savi.ecom.service.UserService;
import com.savi.ecom.user.api.LoginRequest;

@Service
public class UserServiceImpl implements UserService {
	

	private UserRepository userRepository;
	private UserConvertor userConvertor;
	
	@Autowired
	public void setUserRepository(UserRepository userRepository,UserConvertor userConvertor) {
		this.userRepository = userRepository;
		this.userConvertor = userConvertor;
	}

	
	public boolean login(LoginRequest request){
		
		UserModel user = null;
		
		user = userRepository.findByEmail(request.getUsername());
		if (user == null) {
            throw new AuthenticationException();
        }
        String hashedPassword = null;
        try {
            hashedPassword = user.hashPassword(request.getPassword());
        } catch (Exception e) {
            throw new AuthenticationException();
        }
        if (hashedPassword.equals(user.getPassword())) {
            return true;
        } else {
            throw new AuthenticationException();
        }
		
	
	}
	
	
	public UserModel createUser(UserDTO userDto) {
		UserModel user = userConvertor.convert(userDto);
		
		UserModel searchedForUser =  userRepository.findByEmail(user.getEmail());
		if (searchedForUser != null) {
            throw new DuplicateUserException();
        }
		//  Else Create New User
		
		try {
			user.setPassword(user.hashPassword(user.getPassword()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserModel newUser = userRepository.save(user);
		
		
		return newUser;
	}


	public boolean validateEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}
	

}



