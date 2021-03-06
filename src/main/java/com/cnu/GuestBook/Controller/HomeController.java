package com.cnu.GuestBook.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cnu.GuestBook.MessageDAO;
import com.cnu.GuestBook.MessageVO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Resource(name = "MessageDAO")
	private MessageDAO messageDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/goGuestBookPage", method = RequestMethod.GET)
	public String goGuestBookPage(HttpServletRequest request, Model model) {

		List<MessageVO> allMessage = this.messageDAO.select();
	
		allMessage = MessageController.sortMessageByLastestDate(allMessage);
		
		for (MessageVO message : allMessage) {
			logger.info(message.toString());
		}
		model.addAttribute("list", allMessage);

		return "guestBookPage";

	}
	
	@RequestMapping(value = "/goToTuiPage", method = RequestMethod.GET)
	public String goToTuiPage(HttpServletRequest request, Model model) {

		return "tui";
	}

}
