package com.savi.ecom.service;

import java.util.List;

import com.savi.ecom.model.ProductModel;

/**
 * The Interface ProductService.
 */
public interface ProductService extends ModelService<ProductModel>{
	
	/**
	 * Gets the active products.
	 *
	 * @return the active products
	 */
	public List<ProductModel> getActiveProducts();

}
