package com.savi.ecom.dao;

import com.savi.ecom.model.Model;

/**
 * The Interface ModelDao.
 *
 * @param <T> the generic type
 */
public interface ModelDao<T extends Model> {
	
	/**
	 * Creates the.
	 *
	 * @param model the model
	 */
	public void create(T model);
	
	/**
	 * Update.
	 *
	 * @param model the model
	 */
	public void update(T model);
	
	/**
	 * Delete.
	 *
	 * @param model the model
	 */
	public void delete(T model);
	
	/**
	 * Modify.
	 *
	 * @param model the model
	 */
	public void modify(T model);

}
