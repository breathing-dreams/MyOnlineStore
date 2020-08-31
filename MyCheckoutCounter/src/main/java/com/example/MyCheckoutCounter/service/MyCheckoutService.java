package com.example.MyCheckoutCounter.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.MyCheckoutCounter.model.Bill;
import com.example.MyCheckoutCounter.model.Product;

@Component
public interface MyCheckoutService {


	Product getProductById(Long theProductId, int theQuantity);

	List<Product> getAllProducts();

	Bill getBill();

}
