package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
//	@RequestMapping("/challenge")
//	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model ) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}
	
	@RequestMapping(value = {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model ) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}
	
//	@RequestMapping(value = {"challenge/{name}"})
//	public String challengePath(@PathVariable String name, Model model ) {
//		model.addAttribute("name", name);
//		return "challenge";
//	}
	
//	@RequestMapping(value = {"/challenge","challenge/{name}"})
//	public String challengePath(@PathVariable Optional<String> name, Model model ) {
//		if (name.isPresent()) {
//			model.addAttribute("name", name.get());
//		} else {
//			model.addAttribute("name", "KB");
//		}
//		return "challenge";
//	}
	
	@RequestMapping("/generator")
	public String generator(
			@RequestParam(value = "a", required = false, defaultValue = "0") int a,
			@RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("hm", "hm");
		if (a > 1 | b > 1) {
			if(b < 1) {
				model.addAttribute("hm", gen(a,1)); 
			}else {
				model.addAttribute("hm", gen(a,b));
			}
		}
		return "generator";
	}
	
	public String gen(int a, int b) {
		String hm = "hm";
		String hasil = "";
		for (int i = a-1; i > 0; i--) {
			hm += "m";
		}
		
		for (int i = b; i > 0; i--) {
			hasil += " " + hm;
		}
		
		return hasil;
	}
	

}
