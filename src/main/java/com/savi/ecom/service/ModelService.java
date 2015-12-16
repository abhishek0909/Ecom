package com.savi.ecom.service;

import com.savi.ecom.model.Model;

/**
 * The Interface ModelService.
 *
 * @param <T> the generic type
 */
public interface ModelService<T extends Model> {

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
