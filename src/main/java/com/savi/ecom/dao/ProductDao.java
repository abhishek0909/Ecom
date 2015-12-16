package com.savi.ecom.dao;

import java.util.List;

import com.savi.ecom.model.ProductModel;

/**
 * The Interface ProductDao.
 */
public interface ProductDao extends ModelDao<ProductModel>{
	
	/**
	 * Gets the active products.
	 *
	 * @return the active products
	 */
	public List<ProductModel> getActiveProducts();
	
}
