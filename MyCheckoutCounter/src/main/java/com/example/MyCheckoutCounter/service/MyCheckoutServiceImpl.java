package com.example.MyCheckoutCounter.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyCheckoutCounter.dao.ProdCatalogueRepository;
import com.example.MyCheckoutCounter.dao.ProductRepository;
import com.example.MyCheckoutCounter.model.Product;
import com.example.MyCheckoutCounter.model.ProductCatalogue;

@Service
public class MyCheckoutServiceImpl implements MyCheckoutService{
	
	
	
	private ProductCatalogue prodCatalogue;
	
	private Product product;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProdCatalogueRepository prodCatalogueRepository;
	
	@PostConstruct
    public void init() {
		prodCatalogue = new ProductCatalogue(); 
		product=new Product(); 
		
	}
	
	//get product details from catalogue
	public ProductCatalogue getProductDetailsById(Long theProductId) {
		return prodCatalogueRepository.findById(theProductId).orElseThrow(
				() -> new RuntimeException("Product not found - " + theProductId));
	}

	//returns the product with updated details
	@Override
	public Product getProductById(Long theProductId, int theQuantity) {
		prodCatalogue=this.getProductDetailsById(theProductId);
		product.setProductId(prodCatalogue.getProductId());
		product.setProductName(prodCatalogue.getProductName());
		product.setProductPrice(prodCatalogue.getProductPrice());
		product.setQuantity(theQuantity);
		productRepo.save(product);
		//productList.add(product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
   
}
