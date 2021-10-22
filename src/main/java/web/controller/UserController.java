package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/users")
	public String getAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
}