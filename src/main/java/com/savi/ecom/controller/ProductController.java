package com.savi.ecom.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.savi.ecom.form.ProductForm;
import com.savi.ecom.service.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public String createUser(
			@ModelAttribute("productForm") final ProductForm productForm,
			final HttpServletRequest request, final Model model) throws Exception{
		

		
		String productSlug = productService.createProduct(productForm.getProduct());
		model.addAttribute("product", productSlug);
		
	
		return "viewproduct";
//		return new ModelAndView(new RedirectView("home", true, false));
	}
	
	
}
