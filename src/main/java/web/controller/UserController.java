package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/")
	public String indexPage() {
		return "index";
	}

	@GetMapping(value = "/adminusers")
	public String getAdminUserPage(ModelMap model) {
		model.addAttribute("adminusers", userService.getAllUsers());
		return "adminusers";
	}

	@GetMapping(value = "/users")
	public String getUserPage(ModelMap model) {
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