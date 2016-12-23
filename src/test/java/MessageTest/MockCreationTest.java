package MessageTest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;
public class MockCreationTest {
    private MessageDAO messageDAO;
    private MessageVO messageVO;
    
    
    private List<MessageVO> allMessages = new ArrayList<MessageVO>();
    
    @Before
    public void setupMock() {
       MockitoAnnotations.initMocks(this);
       this.insertMessage(allMessages);
    }

    @Test
    public void testMockCreation()   {
    	

        
    	when( messageDAO.select() ).thenReturn( new ArrayList<MessageVO>());
    	assertNotNull(messageDAO.select());
        assertNotNull(messageVO);
        assertNotNull(messageDAO);
    }
    
    public List<MessageVO> insertMessage( List<MessageVO> allMessages)
    {
    	MessageVO message1 = new MessageVO();
    	message1.setIdMessage(1);
    	message1.setEmail("jhg3182@naver.com");
    	message1.setPassword("1234");
    	message1.setDate("2016.12.12 12:12:12");
    	message1.setModifiedDate("2016.12.12 12:12:12");
    	message1.setText("hello");
    	
    	MessageVO message2 = new MessageVO();
    	message2.setIdMessage(2);
    	message2.setEmail("second@naver.com");
    	message2.setPassword("5555");
    	message2.setDate("2016.12.13 12:12:12");
    	message2.setModifiedDate("2016.12.13 12:12:12");
    	message2.setText("HI");
    	
    	
    	allMessages.add(message1);
    	allMessages.add(message2);
    	
    	return allMessages;
    }
}