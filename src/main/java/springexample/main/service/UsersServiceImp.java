package springexample.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import springexample.main.model.User;

@Service("userService")
public class UsersServiceImp implements UserService {

	
	final String json_placeholder_api_for_user = "https://jsonplaceholder.typicode.com/users";
	
	
	@Override
	public User[] getUsers() {	
		RestTemplate restTemp = new RestTemplate();
		User[] result = restTemp.getForObject(json_placeholder_api_for_user, User[].class);
		return result;
	}

	@Override
	public User getSpecificUser(Long userId) {
		RestTemplate restTemp = new RestTemplate();
		User result = restTemp.getForObject(json_placeholder_api_for_user +"/"+ userId, User.class);
		return result;
	}

}
