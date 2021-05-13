package com.capg.basic.SpringMVCapp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

// Manage Database

@Component
public class ProductDAOImpl {

	List<Product> list = new LinkedList<Product>();

	public ProductDAOImpl() {
		
		Product p1 = new Product(101, "HP-101",45000,4);
		Product p2 = new Product(102, "HP-102",15000,3);
		Product p3 = new Product(103, "HP-103",25000,5);
		Product p4 = new Product(104, "HP-104",20000,4);
		Product p5 = new Product(105, "HP-105",145000,3);
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
	
	}
	
	public List<Product> getAllProducts()
	{
		return list;
	}
	
	public List<Product> getProductsByRange(int r1,int r2)
	{
		
		Comparator<Product> comp = (p1,p2)->p1.getProductCost() - p2.getProductCost();
		
		List<Product> productList = list.stream().
		filter((product)->product.getProductCost()>=r1&&product.getProductCost()<=r2).
		collect(Collectors.toList());
		
		return productList;
	}
	
	public Product doAdd(Product product)
	{
		list.add(product);
		return product;
	}
	
	public Product updateproduct(Product d,int searchid)
	{
		Product p=getProductById(searchid);
		p.setProductCost(d.getProductCost());
		p.setProductId(d.getProductId());
		p.setProductName(d.getProductName());
		p.setRating(d.getRating());
		return p;
		
	}
	
	public Product getProductById(int searchid)
	{
		boolean isIdFound = false;
		Product searchedProduct = null;
		for (Product product : list) {
			if(product.getProductId() == searchid)
			{
				isIdFound = true;
				searchedProduct = product;
				break;
			}
		}
		return searchedProduct;
	}
	
	public Product getProductbyRating(int searchrate) {
		boolean isFound = false;
		Product searchedProduct = null;
		for(Product product : list) {
			if(product.getRating() == searchrate) {
				isFound = true;
				searchedProduct = product;
				break;
			}
		}
		
		return searchedProduct;	
	}
	
	public Product doDeleteById(int delId)
	{
		Product p = getProductById(delId);
		boolean x = false;
		if(p != null)
		{
			System.out.println(" ===> DAO List Size before delete "+list.size()+" and p "+p);
			x = list.remove(p);
			System.out.println(" ===> DAO List Size after delete "+list.size());
			System.out.println(" ===>> DAO Delete operation "+x);
		}
		
		if(x) return p;
		else return null;
	}

}//end class
