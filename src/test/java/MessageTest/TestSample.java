package MessageTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.cnu.GuestBook.Controller.HomeController;
import com.cnu.GuestBook.Controller.MessageController;

import junit.framework.TestCase;

@ContextConfiguration("servlet-context.xml")
@WebAppConfiguration

public class TestSample extends TestCase {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	private MessageController MessageController = null;
	HomeController hc = null;

	@Override
	protected void setUp() throws Exception {
		MessageController mc = new MessageController();
		HomeController hc = new HomeController();
	}


	@Test
	public void testController2() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();

		String result = "guestBookPage";
		assertEquals("guestBookPage", result);

		System.out.println(request.getParameter("/"));

	}
}
