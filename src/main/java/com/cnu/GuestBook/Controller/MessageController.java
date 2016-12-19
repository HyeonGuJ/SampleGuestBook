package com.cnu.GuestBook.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;

@Controller
public class MessageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Resource(name = "MessageDAO")
    private MessageDAO messageDAO;
	
	
	@RequestMapping(value = "/getAllMessage", method = RequestMethod.GET)
	public String getAllMessage(Locale locale, Model model) {
	
		List<MessageVO> allMessage = this.messageDAO.select();		
		return "message";
	}
	
	@RequestMapping(value = "/goToWritePage", method = RequestMethod.GET)
	public String goToWritePage(Locale locale, Model model) {
		
		return "write";
		
	}
	
	
    @RequestMapping(value = "/insertMessage")
    public String insertMessage(@ModelAttribute("mVO") MessageVO mVO,  Model model){
        
    	logger.info("insertMessage");
 	
    	
    	Date now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
    	mVO.setDate(sdf.format(now));
    	mVO.setModifiedDate(sdf.format(now));
    	
    	
    	System.out.println(mVO);
    	this.messageDAO.insert(mVO);
		
		List<MessageVO> allMessage = this.messageDAO.select();
		for (MessageVO message : allMessage) {
			System.out.println(message);
		}

		model.addAttribute("list", allMessage);
		
		
    	return "guestBookPage";
    	

    }
    
    @RequestMapping(value = "/modifyMessage", method = RequestMethod.GET)
    public String modifyMessage(@RequestParam(value="idMessage") int idMessage, Model model) {
        logger.info("modifyMessage - idMessage : "+ idMessage);


        return "modify";
    }
    

}
