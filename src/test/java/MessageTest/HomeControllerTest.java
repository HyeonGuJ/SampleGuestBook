package MessageTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.cnu.GuestBook.Controller.HomeController;

@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class HomeControllerTest {

    @Mock
    private HomeController homeController;

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

    	this.mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
    }
    
    
/*    @Test
    public void goGuestBookPage() throws Exception {    	

    	this.mockMvc.perform(get("/goGuestBookPage"))
        .andExpect(status().isOk())
        .andExpect(forwardedUrl("/WEB-INF/views/guestBookPage.jsp"));
    }*/

}