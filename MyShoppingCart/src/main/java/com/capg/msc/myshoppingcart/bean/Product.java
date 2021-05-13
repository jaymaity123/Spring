package com.capg.msc.myshoppingcart.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@NotEmpty(message = "Product name cannot be left blank or null")
	@Size(min = 2,max = 15,message = "Invalid Product Name")
	private String productName;
	@Min(value = 10000,message = "Cost cannot be less than 1000")
	private int productCost;
	@Min(value = 1, message = "Ratings Cannot be Less than 1" )
	@Max(value = 5, message = "Ratings Cannot be More than 5" )
	private int startRating;
	@NotEmpty(message = "Product name cannot be left blank or null")
	private String category;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Product(int productId, String productName, int productCost, int startRating, String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCost = productCost;
		this.startRating = startRating;
		this.category = category;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getProductCost() {
		return productCost;
	}


	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}


	public int getStartRating() {
		return startRating;
	}


	public void setStartRating(int startRating) {
		this.startRating = startRating;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + productCost;
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + startRating;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (productCost != other.productCost)
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (startRating != other.startRating)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCost=" + productCost
				+ ", startRating=" + startRating + ", category=" + category + "]";
	}

}
