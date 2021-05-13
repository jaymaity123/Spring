package com.capg.msc.myshoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.msc.myshoppingcart.bean.Product;
import com.capg.msc.myshoppingcart.dao.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}
	
	
	
	@Override
	@Transactional
	public Product saveProduct(Product p) {
		
		repo.save(p);
		return null;
		
		
	}
	
	@Override
	public List<Product> getAllProductsByCategory(String category) {
		
		return repo.getProductByCategory(category);
	}

	@Override
	public List<Product> getAllProductsByCategoryAndPrice(String category, int range1, int range2) {
		
		return repo.getProductByCategoryAndPrice(category, range1, range2);
	}
	
	
	public void delete(int productId)
	{
		repo.deleteById(productId);
	}
	
	@Override
	public Product getProductById(int id)  {
		return repo.findById(id).get();
		
	}

}