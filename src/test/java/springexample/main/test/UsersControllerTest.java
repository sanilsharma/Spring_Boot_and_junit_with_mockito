package springexample.main.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import springexample.main.controller.UsersController;
import springexample.main.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
@ContextConfiguration(classes = { UsersController.class })
public class UsersControllerTest {

	private static final String api_get_users = "/api2/users";
	private static final String api_get_specific_user = "/api2/user/1";

	@Autowired
	private MockMvc mvc;

	@SpyBean
	private UserService userService;
	
	@MockBean
	private UserService users;

	@Test
	public void getAllUsers() throws Exception {
		String usersList = builduserList();
		when(users.getUsers()).thenReturn(usersList);
		mvc.perform(get(api_get_users).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

	}
	
	private String builduserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void getSpecificUser() throws Exception {
		mvc.perform(get(api_get_specific_user).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

	}

}
