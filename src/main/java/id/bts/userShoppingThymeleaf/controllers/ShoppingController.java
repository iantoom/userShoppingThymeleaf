package id.bts.userShoppingThymeleaf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.bts.userShoppingThymeleaf.domains.Shopping;
import id.bts.userShoppingThymeleaf.services.ShoppingService;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;
	
	@GetMapping(params = {"page", "size"})
	public String shoppingPage(Model model, @RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		
			page = page - 1;
			model.addAttribute("shoppings", shoppingService.getAllShopping(page, size));
			
		return "Shopping/ShoppingIndex";
	}
	
	@GetMapping("/{id}")
	public String viewShoppingModel(Model model, @PathVariable Long id) {
		
		model.addAttribute("shopping", shoppingService.getShoppingById(id));
		
		return "Shopping/ShoppingDetail";
	}
	
	@GetMapping("/form")
	public String shoppingForm(Model model) {
		model.addAttribute("shopping", new Shopping());
		return "Shopping/ShoppingForm";
	}
	
	@PostMapping("/save")
	public String saveShopping(@Valid @ModelAttribute("shopping")Shopping shopping, 
		      BindingResult result, ModelMap model) {
		
		Shopping savedShopping = shoppingService.saveShopping(shopping);
		model.addAttribute("shopping", savedShopping);
		return "Shopping/ShoppingDetail";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteShopping(@PathVariable Long id, Model model) {
		shoppingService.deleteShopping(id);
		
		
		model.addAttribute("shoppings", shoppingService.getAllShopping(1, 2));
		return "Shopping/ShoppingIndex";
	}
}
