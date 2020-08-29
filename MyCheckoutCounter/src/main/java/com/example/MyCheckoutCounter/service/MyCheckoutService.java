package com.example.MyCheckoutCounter.service;

import java.util.List;

import com.example.MyCheckoutCounter.model.Product;

public interface MyCheckoutService {


	Product getProductById(Long theProductId, int theQuantity);

	List<Product> getAllProducts();

}
