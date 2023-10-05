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
import org.springframework.web.bind.annotation.RequestParam;

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
	
//	@GetMapping("/pizze")
//	public String getPizze(Model model) {
//		
//		List<Pizza> pizze = pizzaService.findAll();
//		model.addAttribute("pizze", pizze);
//		return "pizze-index";
//		
//	}
	
	@GetMapping("/pizze")
	public String getPizze(
			Model model, 
			@RequestParam(required = false) String nomePizza) {
		
//		List<Pizza> pizze = null;
//		if(nomePizza == null) {
//			pizze = pizzaService.findAll();
//			model.addAttribute("pizze", pizze);
//		}else {
//			pizze = pizzaService.findByNome(nomePizza);
//			model.addAttribute("pizze", pizze);
//		}
		//stessa condizione ma fatta con un ternario
		List<Pizza> pizze = nomePizza == null
						? pizzaService.findAll()
						: pizzaService.findByNome(nomePizza);
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
