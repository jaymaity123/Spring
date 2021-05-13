package com.capg.basic.SpringMVCapp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
	
	@Autowired
	ProductDAOImpl dao;
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello";
	}
    
	//            localhost:9096:\product\10000\40000
	//  endpoint :- www.abc.com\product\10000\40000
	@GetMapping("/product/{r1}/{r2}")
	public List<Product> getProductsbyrange(@PathVariable int r1 ,@PathVariable int r2)
	{
		return dao.getProductsByRange(r1, r2);
	}
	
	// ..../product/101
	@GetMapping("/product/{searchid}")
	public Product getProductById(@PathVariable int searchid)
	{
		return dao.getProductById(searchid);
	}
	
	@PostMapping("/product/newproduct")
	public Product insertProduct(@RequestBody Product product)
	{
		System.out.println("Saved Product");
		return dao.doAdd(product);
	}
	
	@PutMapping("/product")
	public Product updateproduct( @RequestBody Product d,@PathVariable int searchid)
	{
		return dao.updateproduct(d, searchid);
		
	}
	
	
	@GetMapping("/rating/product/{searchrate}")
	public Product getProductbyStarRating(@PathVariable int searchrate)
	{
		return dao.getProductbyRating(searchrate);
	}
	
	@GetMapping("/delete/product/{deleteproduct}")
	public List<Product> doDeleteById(@PathVariable int delId) 
	{
		
		return dao.getAllProducts();
	}
}
