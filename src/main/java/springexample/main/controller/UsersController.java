package springexample.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springexample.main.model.User;
import springexample.main.service.UserService;


@RestController
@RequestMapping("/api2")
public class UsersController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public User[] getUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUsers(@PathVariable(value = "id") Long userId) {
		return userService.getSpecificUser(userId);
	}
}
