package com.savi.ecom.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.savi.ecom.dao.ProductDao;
import com.savi.ecom.model.ProductModel;

public class ProductDaoImpl implements ProductDao {

	private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public void create(ProductModel model) {
		// TODO Auto-generated method stub
	}

	public void update(ProductModel model) {
		// TODO Auto-generated method stub
		
	}

	public void delete(ProductModel model) {
		// TODO Auto-generated method stub
		
	}

	public void modify(ProductModel model) {
		// TODO Auto-generated method stub
		
	}

	public List<ProductModel> getActiveProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
