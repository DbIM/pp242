package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;


@Controller
public class UserController {

	UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/users")
	@ResponseBody
	public String getAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
}