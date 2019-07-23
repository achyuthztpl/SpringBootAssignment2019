package com.learning.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("inside");
		return "test";
	}
}
