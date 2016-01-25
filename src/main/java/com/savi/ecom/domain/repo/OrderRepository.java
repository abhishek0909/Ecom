package com.savi.ecom.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.savi.ecom.model.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {
 
	@Query("select o from OrderModel o where uuid = ?")
	OrderModel findByUuid(String uuid);

}
