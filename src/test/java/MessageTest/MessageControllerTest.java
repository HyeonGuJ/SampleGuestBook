package MessageTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageMapper;
import com.cnu.GuestBook.MessageVO;
import com.cnu.GuestBook.Controller.MessageController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Transactional
@WebAppConfiguration

public class MessageControllerTest {

	@Resource
	private MessageDAO messageDAO;

	@Resource
	private MessageMapper messageMapper;

	@Resource
	private MessageController messagController;

	@Before
	public void setUp() {
		messagController = new MessageController();

		deleteAll();
		insertTwoElements();

	}

	private void insertTwoElements() {
		
		messageDAO.insert(maketMessage1());
		int idMessage_m1 = getIDMessageOfLastestMessage(messageDAO.select());

		messageDAO.insert(maketMessage2());
		int idMessage_m2 = getIDMessageOfLastestMessage(messageDAO.select());
	}

	private void deleteAll() {
		for (MessageVO mVO : messageDAO.select()) {
			messageDAO.deleteById(mVO.getIdMessage());
		}

	}
	@Test
	public void test()
	{
		assertTrue(true);
	}

	@Test
	public void test_01_insertNSelectAll() {

		int beforeSize = messageDAO.select().size();

		messageDAO.insert(maketMessage1());
		int idMessage_m1 = getIDMessageOfLastestMessage(messageDAO.select());

		messageDAO.insert(maketMessage2());
		int idMessage_m2 = getIDMessageOfLastestMessage(messageDAO.select());

		int afterSize = messageDAO.select().size();

		assertTrue(idMessage_m1 < idMessage_m2);
		assertTrue(afterSize - beforeSize == 2);

	}

	@Test
	public void test_02_modify() {

		// insert
		messageDAO.insert(maketMessage1());
		int idMessage_m1 = getIDMessageOfLastestMessage(messageDAO.select());

		// get inserted one
		MessageVO messageVO = messageDAO.selectById(idMessage_m1);

		// modify
		String modifiedText = "modifiedText";
		messageVO.setText(modifiedText);
		messageDAO.update(messageVO);

		// get modified one
		MessageVO modifiedMessageVO = messageDAO.selectById(idMessage_m1);

		// test
		assertEquals(modifiedMessageVO.getText(), modifiedText);
	}

	@Test
	public void test_03_delete() {
		// delete 2 element that was inserted by test_01_insertNSelectAll()
		// delete 1 element that was inserted by test_02_modify()()

		int beforeSize = messageDAO.select().size();

		int idMessage_m1 = getIDMessageOfLastestMessage(messageDAO.select());
		messageDAO.deleteById(idMessage_m1);

		int afterSize = messageDAO.select().size();
		assertTrue(beforeSize - afterSize == 1);
	}

	@Test
	public void test_04_sortAllMessageByTime() {

	}

	private ArrayList<MessageVO> sortMessageByLastestDate() {
		// TODO
		// sort by lastest date

		return null;
	}

	@Test
	public void test_99_isCorrectEmailTest() {
		assertTrue(messagController.isCorrectEmailFormat("jhg3182@naver.com"));
		assertFalse(messagController.isCorrectEmailFormat("jhg3182naver.com"));
		assertFalse(messagController.isCorrectEmailFormat("jhg3182@navercom"));
		assertFalse(messagController.isCorrectEmailFormat("jhg3182navercom"));

	}

	@Test
	public void test_99_dateString2Integer()
	{
		Long dateLong = new Long ("20161212121212");
		String input = "2016.12.12 12:12:12.0";
		System.out.println(input);
		Long parsedDate = 0l;
		parsedDate =  messagController.dateString2Long(input);
		assertEquals(dateLong,parsedDate);
	}
	private MessageVO maketMessage1() {
		MessageVO message1 = new MessageVO();
		message1.setIdMessage(1);
		message1.setEmail("test@test.com");
		message1.setPassword("1234");
		message1.setDate("2016.12.12 12:12:12");
		message1.setModifiedDate("2016.12.12 12:12:12");
		message1.setText("hello");

		return message1;
	}

	private MessageVO maketMessage2() {
		MessageVO message2 = new MessageVO();
		message2.setIdMessage(2);
		message2.setEmail("second@test.com");
		message2.setPassword("5555");
		message2.setDate("2016.12.13 12:12:13");
		message2.setModifiedDate("2016.12.13 12:12:12");
		message2.setText("HI");

		return message2;
	}

	private int getIDMessageOfLastestMessage(List<MessageVO> list) {
		// TODO
		// get biggest idMessage in messages.
		// idMessage -> auto Increment -> last element in messages
		return list.get(list.size() - 1).getIdMessage();
	}

}
