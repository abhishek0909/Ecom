package com.savi.ecom.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savi.ecom.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	
	UserModel findByEmail(String email);
}
