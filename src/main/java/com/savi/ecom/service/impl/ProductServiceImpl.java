package com.savi.ecom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savi.ecom.convertor.ProductConvertor;
import com.savi.ecom.domain.repo.ProductRepository;
import com.savi.ecom.dto.ProductDTO;
import com.savi.ecom.model.ProductModel;
import com.savi.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConvertor productConvertor;
	
	
	
	
	public String createProduct(ProductDTO prod){
		
		ProductModel product = productConvertor.convert(prod);
		
		product = productRepository.save(product);
		
		return product.getSlug();
	}
}
