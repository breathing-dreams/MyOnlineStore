package com.example.MyCheckoutCounter.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	private Long productId;
	private String productName;
	private Double productPrice;	
	private int quantity;
	private Double totalAmount;
	
	public Product(){
		
	}
	
	public Product(String productName, Double productPrice, int quantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.totalAmount = this.productPrice * this.quantity;
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
		return this.productPrice * this.quantity;
	}
	

}
