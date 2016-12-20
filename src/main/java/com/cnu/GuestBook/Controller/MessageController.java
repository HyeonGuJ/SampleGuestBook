package com.cnu.GuestBook.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;

@Controller
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Resource(name = "MessageDAO")
    private MessageDAO messageDAO;
	
	
	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	@RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
	public String getAllMessage(Model model) {
	
		
		List<MessageVO> allMessage = selectAll();
		for (MessageVO message : allMessage) {
			System.out.println(message);
		}
		model.addAttribute("list", allMessage);
		
		return "guestBookPage";
	}

	public List<MessageVO> selectAll() {
		List<MessageVO> allMessage = this.messageDAO.select();
		return allMessage;
	}
	
	@RequestMapping(value = "/goToWritePage", method = RequestMethod.GET)
	public String goToWritePage() {
		
		return "write";
		
	}
	
	
    @RequestMapping(value = "/insertMessage")
    public String insertMessage(@ModelAttribute("mVO") MessageVO mVO,  Model model){
        
    	logger.info("insertMessage");
 	
    	
    	Date now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
    	mVO.setDate(sdf.format(now));
    	mVO.setModifiedDate(sdf.format(now));
    	

    	if(hasEmptyContents(mVO) )
    	{
    		System.out.println(" insert fail...");
    		return getAllMessage(model);
    	}
    	
    	
    	if(isCorrectEmailFormat(mVO.getEmail()))
    	{
    		System.out.println(mVO);
        	this.messageDAO.insert(mVO);
        	return getAllMessage(model);
    	}
    	else
    	{
    		System.out.println(" insert fail...");
    	}
		
			
    	return getAllMessage(model);
    	

    }

	private boolean hasEmptyContents(MessageVO mVO) {

		return mVO.getEmail().equals("")
				|| mVO.getPassword().equals("") 
				|| mVO.getText().equals("") ;
	}

	public boolean isCorrectEmailFormat(String email) {
    	return Pattern.matches("[A-Za-z0-9_.-]+@([A-Za-z0-9_]+\\.)+[A-Za-z]{2,4}", email);  	
	}

	@RequestMapping(value = "/modifyMessage", method = RequestMethod.GET)
    public String modifyMessage(@RequestParam(value="idMessage") int idMessage, Model model) {
        logger.info("modifyMessage - idMessage : "+ idMessage);


        return "modify";
    }
    
    

}
