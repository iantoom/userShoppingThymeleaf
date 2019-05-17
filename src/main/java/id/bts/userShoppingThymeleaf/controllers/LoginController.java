package id.bts.userShoppingThymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import id.bts.userShoppingThymeleaf.domains.UserDetails;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String loginPage(Model model) {
		//model.addAttribute("user", new UserDetails());
		return "Login";
	}
	
	
}
