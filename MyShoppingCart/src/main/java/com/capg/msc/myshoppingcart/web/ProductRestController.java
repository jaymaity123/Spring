package com.capg.msc.myshoppingcart.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.exception.InvalidCategoryException;
import com.capg.msc.myshoppingcart.exception.InvalidCostRangeException;
import com.capg.msc.myshoppingcart.service.ProductService;
@Validated
@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	private ProductService service;
		
	@GetMapping("/home")
	public String homeRequest()
	{
		return " Welcome User! : My Shopping App1 " + LocalDateTime.now();
		
	}

	
	public ProductRestController() {
		System.out.println("---> Inside the ProductRestController Constructor");
		
	}
	
	@PostMapping("/product")
	public Product insertProduct(@RequestBody @Valid Product product) {
		
		service.saveProduct(product);
		return product;
		
	}
	
	@PutMapping("/product/new")
	public Product update(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@DeleteMapping("delete/product/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId)
	{
		service.delete(productId);
	}
	
	@GetMapping("/category/{category}")
	public List<Product> getAllProductsByCategory(@PathVariable String category) throws InvalidCategoryException
	{
		if(category!="LAPTOP" || category!="CAMERA")
		{
			throw new InvalidCategoryException(category);
		}
		return service.getAllProductsByCategory(category);
	}
	
	@GetMapping("/products/{category}/{range1}/{range2}")
	public List<Product> getAllProductsByCategoryAndPrice(@PathVariable String category,
			@PathVariable int range1,@PathVariable int range2)throws InvalidCostRangeException
	{
		if(category.equals("CAMERA")&&range1<10000)
		{
			throw new InvalidCostRangeException(range1,range2);
		}
		return service.getAllProductsByCategoryAndPrice(category, range1, range2);
	}
	
	
	@GetMapping("/products")
	public List<Product> insertAllProduct(@RequestBody Product product) {
		
		
		return service.getAllProducts();
		
	}
}