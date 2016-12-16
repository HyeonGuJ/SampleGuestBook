package com.cnu.GuestBook.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cnu.GuestBook.domain.Message;
import com.cnu.GuestBook.mybatis.ConnectionFactory.MyBatisConnectionFactory;
import com.cnu.GuestBook.persistence.MessageDAO;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );		
		
		return "home";
	}
	
    @RequestMapping(value = "/goGuestBookPage", method = RequestMethod.GET)
    public ModelAndView logoff(HttpServletRequest request, Model model){
        
    	return new ModelAndView("guestBookPage");
    	

    }

}
