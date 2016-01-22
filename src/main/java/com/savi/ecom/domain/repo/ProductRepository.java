package com.savi.ecom.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.savi.ecom.model.ProductModel;
import com.savi.ecom.model.UserModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

	
	 ProductModel findBySlug(String slug);
	
	 @Query("select u from ProductModel u where uuid = ?")
	 UserModel findByUuid(String uuid);
}