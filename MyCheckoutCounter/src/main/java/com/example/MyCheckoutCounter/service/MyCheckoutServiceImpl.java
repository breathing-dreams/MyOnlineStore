package com.example.MyCheckoutCounter.service;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MyCheckoutCounter.dao.BillRepository;
import com.example.MyCheckoutCounter.dao.ProdCatalogueRepository;
import com.example.MyCheckoutCounter.dao.ProductRepository;
import com.example.MyCheckoutCounter.model.Bill;
import com.example.MyCheckoutCounter.model.Product;
import com.example.MyCheckoutCounter.model.ProductCatalogue;

@Service
public class MyCheckoutServiceImpl implements MyCheckoutService{
	

	private Bill bill;
	
	private ProductCatalogue prodCatalogue;
	
	private Product product;
	
	List<Product> tempList;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProdCatalogueRepository prodCatalogueRepository;
	
	@Autowired
	private BillRepository billRepository;
	
	@PostConstruct
    public void init() {
		prodCatalogue = new ProductCatalogue(); 
		product=new Product(); 
		bill=new Bill();
		
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
		product.setCategory(prodCatalogue.getCategory());
		product.setTotalAmount();
		product.setSaleTax();
		productRepo.save(product);
		//productList.add(product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public Bill getBill() {
		tempList=productRepo.findAll();
		double salesTax=0, grandTotal=0;
		for(Product p:tempList)
		{
			salesTax+=p.getSaleTax();
			grandTotal+=p.getTotalAmount();
		}
		bill.setProductList(tempList);
		bill.setTotalPrice(salesTax+grandTotal);
		bill.setSalesTax(salesTax);
		billRepository.save(bill);
		return bill;
	}
	

	
   
}
