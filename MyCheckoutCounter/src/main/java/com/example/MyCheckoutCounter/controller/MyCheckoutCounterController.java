package com.example.MyCheckoutCounter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MyCheckoutCounter.dao.ProdCatalogueRepository;
import com.example.MyCheckoutCounter.dao.ProductRepository;
import com.example.MyCheckoutCounter.model.Bill;
import com.example.MyCheckoutCounter.model.Product;
import com.example.MyCheckoutCounter.model.ProductCatalogue;

@Controller
@RequestMapping("/onlinestore")
public class MyCheckoutCounterController {
	
	
	private Bill bill;
	private List<Product> productList;
	
	
	private Product product;
	
	private ProductCatalogue prodCatalogue;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProdCatalogueRepository prodCatalogueRepository;
	
	 @PostConstruct
	    public void init() {
		 prodCatalogue = new ProductCatalogue(); 
		 product=new Product();
		 productList=new ArrayList<Product>();
	   }
	
	@GetMapping("/home")
	public String onlineStoreHome() {
		return "home";
	}
	
	@GetMapping("/checkoutcounter")
	public String getCheckoutCounter() {
		return "checkout-counter";
	}
	
	@PostMapping("/scanProductId")
	public String withdrawForm(@RequestParam("theProductId") Long theProductId,@RequestParam("theQuantity") int theQuantity,
			Model theModel) {
		
		
		prodCatalogue=prodCatalogueRepository.findById(theProductId).orElseThrow(
				() -> new RuntimeException("Product not found - " + theProductId));
		product.setProductId(prodCatalogue.getProductId());
		product.setProductName(prodCatalogue.getProductName());
		product.setProductPrice(prodCatalogue.getProductPrice());
		product.setQuantity(theQuantity);
		productList.add(product);
		theModel.addAttribute("productList", productList);
		return "checkout-counter";
	}
	
	@GetMapping("generateBill")
	public String generateBill() {
		return "final-bill";
	}

}
