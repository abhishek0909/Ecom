package com.savi.ecom.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.savi.ecom.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {

	
	UserModel findByEmail(String email);
	
	 @Query("select u from UserModel u where uuid = ?")
	 UserModel findByUuid(String uuid);
}
