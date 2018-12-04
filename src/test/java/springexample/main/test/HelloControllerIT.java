package springexample.main.test;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import springexample.main.controller.HelloController;
import springexample.main.repository.NoteRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
@ContextConfiguration(classes = { HelloController.class })
public class HelloControllerIT {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private NoteRepository repo;

	@Test
	public void getHello() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().contentType("text/plain;charset=UTF-8"))
				.andExpect(content().string(equalTo("Welcome to the Sanil Sharma's spring boot application")));
	}
}
