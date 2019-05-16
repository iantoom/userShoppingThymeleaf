package id.bts.userShoppingThymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
