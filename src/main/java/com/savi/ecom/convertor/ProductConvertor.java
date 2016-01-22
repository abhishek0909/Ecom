package com.savi.ecom.convertor;

import com.savi.ecom.dto.ProductDTO;
import com.savi.ecom.model.ProductModel;

public class ProductConvertor implements IConvertor<ProductModel, ProductDTO> {

	public ProductModel convert(ProductDTO input) {
		
		ProductModel model = new ProductModel();
		
		model.setName(input.getName());
		model.setPrice(input.getPrice());
		model.setSlug(input.getSlug());
		
		return null;
	}

	
	
	
}
