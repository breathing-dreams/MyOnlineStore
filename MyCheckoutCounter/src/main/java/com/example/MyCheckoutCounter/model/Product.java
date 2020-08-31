package com.example.MyCheckoutCounter.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Product {
	
	@Id
	@NotNull
	private Long productId;
	private String productName;
	private Double productPrice;
	
	private String category;
	@NotNull
	private int quantity;
	private Double totalAmount;	
	private Double saleTax;
	
	public Product(){
		
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalAmount() {
		
		return this.totalAmount;
	}
	
	
	public void setSaleTax() {
		if(category.equalsIgnoreCase("A"))
			this.saleTax = this.totalAmount*0.1;
		else if(category.equalsIgnoreCase("B"))
			this.saleTax = this.totalAmount*0.2;
		else
			this.saleTax = 0.0;
	}

	public Double getSaleTax() {
		return this.saleTax;
	}

	public String getCategory() {
		return category;
	}

	public void setTotalAmount() {
		this.totalAmount = this.productPrice * this.quantity;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	
	

}
