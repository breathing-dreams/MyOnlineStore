package com.example.MyCheckoutCounter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlinestore")
public class MyCheckoutCounterController {
	
	@RequestMapping("/home")
	public String onlineStoreHome() {
		return "home";
	}

}
