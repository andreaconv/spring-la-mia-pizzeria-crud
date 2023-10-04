package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model) {
		
//		final String name = "Andrea";
//		
//		model.addAttribute("name", name);
		
		return "index";
	}
	
	@GetMapping("/pizze")
	public String getPizze(Model model) {
		
		List<Pizza> pizze = pizzaService.findAll();
		model.addAttribute("pizze", pizze);
		return "pizze-index";
		
	}
	
	@GetMapping("/pizze/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		return "pizza-show";
		
	}
}
