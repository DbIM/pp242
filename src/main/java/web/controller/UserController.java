package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String getAllUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/addUser")
	public String createUser(ModelMap model) {
		User user = new User();
		model.addAttribute("users", user);
		return "adduser";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/";
	}

	@GetMapping("/{id}/updateUser")
	public String updateUser(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		return "updateuser";
	}

	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		return "redirect:/";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Long id){
		userService.removeUser(id);
		return "redirect:/";
	}
}