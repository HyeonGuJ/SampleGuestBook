package MessageTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;
import com.cnu.GuestBook.Controller.MessageController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class MessageController_viewTest {
	private MessageDAO messageDAO;

	@Mock
	private MessageController messageController;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

	}

	@Test
	public void goToWritePageTest() throws Exception {

		this.mockMvc.perform(get("/goToWritePage/")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/write.jsp"));

	}
	
	@Test
	public void getAllMessageTest() throws Exception {
		mockMvc.perform(get("/getAllMessage/")).andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/guestBookPage.jsp"));
	}



}