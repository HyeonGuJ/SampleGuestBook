package com.cnu.GuestBook.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

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
	public String goToGuestBookPage(Model model) {
	
		
		return goToGuestBookPageService(model);
	}

	private String goToGuestBookPageService(Model model) {
		List<MessageVO> allMessage = selectAll();
		for (MessageVO message : allMessage) {
			logger.info(message.toString());
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

	
	@RequestMapping(value = "/goToModifyMessage", method = RequestMethod.GET)
	public String goToModifyMessage(@RequestParam(value="idMessage") int idMessage, Model model) {
		
		MessageDAO messageDAO;		
		MessageVO message = this.messageDAO.selectById(idMessage);	
		
		String saved_password = message.getPassword();
		model.addAttribute("saved_password", saved_password);

		
		message.setPassword("");
		model.addAttribute("message", message);		
		model.addAttribute("text", message.getText());
		
		return "modify";
		
	}

	private boolean hasEmptyContents(MessageVO mVO) {

		return mVO.getEmail().equals("")
				|| mVO.getPassword().equals("") 
				|| mVO.getText().equals("") ;
	}

	public boolean isCorrectEmailFormat(String email) {
    	return Pattern.matches("[A-Za-z0-9_.-]+@([A-Za-z0-9_]+\\.)+[A-Za-z]{2,4}", email);  	
	}

	@RequestMapping(value = "/modifyMessage")
	public String modifyMessage(
			@ModelAttribute("mVO") MessageVO mVO, 
			@ModelAttribute("saved_password") String saved_password, 
			Model model, HttpServletResponse response) {

		logger.info("modifyMessage");
		logger.info("message No. :  : "+ mVO.getIdMessage());
		logger.info("[hidden] saved_password : "+ saved_password);
		logger.info(mVO.toString());
		
		
		
		//modified date : current time
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");		
		mVO.setModifiedDate(sdf.format(now));
		
		
		if (hasEmptyContents(mVO)) {
			alert(" modify fail! - one or more items are empty","/GuestBook/goGuestBookPage", response);
			logger.info(" modify fail...");
			return goToGuestBookPage(model);
		}
		
		if (! mVO.getPassword().equals(saved_password)) {
			alert(" modify fail! - incorrect password","/GuestBook/goGuestBookPage", response);
			
		}

		if (!isCorrectEmailFormat(mVO.getEmail())) {
			alert(" modify fail! - Email format is incorrect","/GuestBook/goGuestBookPage", response);
			logger.info(" modify fail...");
			return goToGuestBookPage(model);
		}
			
		logger.info("DB updating...");
		this.messageDAO.update(mVO);
		logger.info("DB update Success!!");
		
		return goToGuestBookPage(model);

	}
    
	@RequestMapping(value = "/insertMessage")
	public String insertMessage(@ModelAttribute("mVO") MessageVO mVO, Model model, HttpServletResponse response) {

		logger.info("insertMessage");

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		mVO.setDate(sdf.format(now));
		mVO.setModifiedDate(sdf.format(now));

		if (hasEmptyContents(mVO)) {			
			logger.info(" insert fail...");
			alert(" insert fail! - One or more items are empty.","/GuestBook/goGuestBookPage", response);			
		}

		if (isCorrectEmailFormat(mVO.getEmail())) {			
			this.messageDAO.insert(mVO);
			return goToGuestBookPage(model);
		} else {
			logger.info(" insert fail...");
			alert(" insert fail! - Email format is incorrect","/GuestBook/goGuestBookPage", response);
		}

		return goToGuestBookPage(model);

	}

	private void alert(String alertMessage, String href, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("EUC-KR");
			writer = response.getWriter();
			writer.println("<script>alert('" + alertMessage + "'); location.href='" + href + "' </script>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

}
