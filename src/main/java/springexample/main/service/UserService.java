package springexample.main.service;

import springexample.main.model.User;

public interface UserService {

	public String getUsers();
	
	public User getSpecificUser(Long userId);
}
