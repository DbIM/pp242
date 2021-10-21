package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("User MVC Test");
		model.addAttribute("messages", messages);
		return "index";
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String helloUser() {
		return "user";
	}
	
}