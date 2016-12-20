package MessageTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;
import com.cnu.GuestBook.Controller.MessageController;


public class messageControllerTest {


	@Resource
	private MessageDAO messageDAO = new MessageDAO();
	
	@Resource
	private MessageController messagController = new MessageController();


	@Test
	public void isCorrectEmailTest() {
		assertTrue(messagController.isCorrectEmailFormat("jhg3182@naver.com"));
		assertFalse(messagController.isCorrectEmailFormat("jhg3182naver.com"));
		assertFalse(messagController.isCorrectEmailFormat("jhg3182@navercom"));
		assertFalse(messagController.isCorrectEmailFormat("jhg3182navercom"));

	}



}
