package springexample.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("userService")
public class UsersServiceImp implements UserService {

	
	final String json_placeholder_api_for_user = "https://jsonplaceholder.typicode.com/users";
	
	
	@Override
	public String getUsers() {	
		RestTemplate restTemp = new RestTemplate();
		String result = restTemp.getForObject(json_placeholder_api_for_user, String.class);
		return result;
	}

	@Override
	public String getSpecificUser(Long userId) {
		RestTemplate restTemp = new RestTemplate();
		String result = restTemp.getForObject(json_placeholder_api_for_user +"/"+ userId, String.class);
		return result;
	}

}
