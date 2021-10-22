package web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;
import web.service.UserService;


@RestController
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

	/*	@GetMapping("/cars")
	public String getCar(ModelMap model, @RequestParam(value = "count", defaultValue = "0", required = false) Integer count) {
		model.addAttribute("cars", carService.carChosenList(count));
		return "cars";


		    public List<Car> carChosenList(int x) {
        return carDao.carChosenList(x);
    }
	}*/

/*	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String helloUser() {
		return "user";
	}*/
	
}