package id.bts.userShoppingThymeleaf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import id.bts.userShoppingThymeleaf.domains.User;
import id.bts.userShoppingThymeleaf.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(params = {"page", "size"})
	public String usersPage(Model model, @RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		
			page = page - 1;
			model.addAttribute("users", userService.getAllUser(page, size));
			
		return "Users/UserIndex";
	}
	
	@GetMapping("/signup")
	public String usersSignup(Model model) {
		
		model.addAttribute("user", new User());
		
		return "Users/SignUp";
	}
	
	@PostMapping("/save")
	public String userSave(@Valid @ModelAttribute("user") User user,
			ModelMap model) {
		
		userService.saveUser(user);
		
		return "redirect:/users?page=1&size=2";
	}
}
