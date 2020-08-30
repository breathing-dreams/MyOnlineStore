package com.example.MyCheckoutCounter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.MyCheckoutCounter.model.Product;
import com.example.MyCheckoutCounter.service.MyCheckoutService;

@Controller
@RequestMapping("/onlinestore")
public class MyCheckoutCounterController {	
	
	@Autowired
	private MyCheckoutService myCheckoutService;
	
	//to remove leading trailing whitespace from input from forms
		@InitBinder
		public void initBinder(WebDataBinder webDatabinder) {
			StringTrimmerEditor stringTrimmer=new StringTrimmerEditor(true);
			
			webDatabinder.registerCustomEditor(String.class, stringTrimmer);
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
		
		myCheckoutService.getProductById(theProductId,theQuantity);
		List<Product> tempList=myCheckoutService.getAllProducts();
		theModel.addAttribute("productList", tempList);
		
		
		return "checkout-counter";
	}
	
	@GetMapping("/generateBill")
	public String generateBill( Model theModel) {
		myCheckoutService.getBill();
		
		return "bill-generate";
	}

}
