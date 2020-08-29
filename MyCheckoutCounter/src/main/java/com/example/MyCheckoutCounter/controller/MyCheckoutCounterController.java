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

import com.example.MyCheckoutCounter.model.Bill;
import com.example.MyCheckoutCounter.model.Product;
import com.example.MyCheckoutCounter.service.MyCheckoutService;

@Controller
@RequestMapping("/onlinestore")
public class MyCheckoutCounterController {
	
	
	private Bill bill;
	
	@Autowired
	private MyCheckoutService myCheckoutService;
	

	
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
		myCheckoutService.getProductById(theProductId,theQuantity);
		theModel.addAttribute("productList", myCheckoutService.getAllProducts());
		return "checkout-counter";
	}
	
	@GetMapping("generateBill")
	public String generateBill() {
		return "final-bill";
	}

}
