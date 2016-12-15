package com.cnu.GuestBook;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Handles requests for the application home page.
 */
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
	
    // 1. 로그아웃 요청시 수행
    @RequestMapping(value = "/goGuestBookPage", method = RequestMethod.GET)
    public ModelAndView logoff(HttpServletRequest request, Model model){
        
        return redirectView(request, "/guestBookMain.jsp");
    }


    //페이지 이동
    private ModelAndView redirectView(HttpServletRequest request, String url){
        RedirectView rv = new RedirectView();
        ModelAndView mav = new ModelAndView(rv);
        rv.setUrl(request.getContextPath() + url);
        
        // GET방식으로 된 파라메터들을 모두 없앰
        rv.setExposePathVariables(false);
        // Model에 등록 된 값들을 모두 없앰
        rv.setExposeModelAttributes(false);
        
        return mav;
    }




}
