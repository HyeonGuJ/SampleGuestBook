package com.cnu.GuestBook.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

		List<MessageVO> allMessage = selectAll();
		allMessage = sortMessageByLastestDate(allMessage);
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
	public String goToModifyMessage(@RequestParam(value = "idMessage") int idMessage, Model model) {

		MessageVO message = this.messageDAO.selectById(idMessage);

		String saved_password = message.getPassword();
		model.addAttribute("saved_password", saved_password);

		message.setPassword("");
		model.addAttribute("message", message);
		model.addAttribute("text", message.getText());

		return "modify";

	}

	private boolean hasEmptyContents(MessageVO mVO) {

		return mVO.getEmail().equals("") || mVO.getPassword().equals("") || mVO.getText().equals("");
	}

	public boolean isCorrectEmailFormat(String email) {
		return Pattern.matches("[A-Za-z0-9_.-]+@([A-Za-z0-9_]+\\.)+[A-Za-z]{2,4}", email);
	}

	@RequestMapping(value = "/modifyMessage")
	public String modifyMessage(@ModelAttribute("mVO") MessageVO mVO,
			@ModelAttribute("saved_password") String saved_password, Model model, HttpServletResponse response) {

		logger.info("modifyMessage");
		logger.info("message No. :  : " + mVO.getIdMessage());
		logger.info("[hidden] saved_password : " + saved_password);
		logger.info(mVO.toString());

		// modified date : current time
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		mVO.setModifiedDate(sdf.format(now));

		if (hasEmptyContents(mVO)) {
			alert(" modify fail! - one or more items are empty", "/GuestBook/goGuestBookPage", response);
			logger.info(" modify fail...");
			return goToGuestBookPage(model);
		}

		if (!mVO.getPassword().equals(saved_password)) {
			alert(" modify fail! - incorrect password", "/GuestBook/goGuestBookPage", response);

		}

		if (!isCorrectEmailFormat(mVO.getEmail())) {
			alert(" modify fail! - Email format is incorrect", "/GuestBook/goGuestBookPage", response);
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
			alert(" insert fail! - One or more items are empty.", "/GuestBook/goGuestBookPage", response);
		}

		if (isCorrectEmailFormat(mVO.getEmail())) {
			this.messageDAO.insert(mVO);
			return goToGuestBookPage(model);
		} else {
			logger.info(" insert fail...");
			alert(" insert fail! - Email format is incorrect", "/GuestBook/goGuestBookPage", response);
		}

		return goToGuestBookPage(model);
	}

	@RequestMapping(value = "/deleteMessage")
	public String deleteMessage(@RequestParam(value = "idMessage") int idMessage, Model model,
			HttpServletResponse response) {

		messageDAO.deleteById(idMessage);
		return goToGuestBookPage(model);
	}

	private void alert(String alertMessage, String href, HttpServletResponse response) {
		PrintWriter writer = null;
		try {

			writer = response.getWriter();
			writer.println("<script>alert('" + alertMessage + "'); location.href='" + href + "' </script>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}

	}

	private List<MessageVO> sortMessageByLastestDate(List<MessageVO> messages) {

		List<Long> dateIntegers = new ArrayList<>();
		for (MessageVO mVO : messages) {
			dateIntegers.add(dateString2Long(mVO.getDate()));
		}
		quickSortMessage(dateIntegers, 0, dateIntegers.size()-1, messages);

		return messages;
	}

	public Long dateString2Long(String dateString) {

		dateString = dateString.replaceAll(" ", "");
		System.out.println(dateString);
		dateString = dateString.replaceAll(":", "");
		System.out.println(dateString);
		dateString = dateString.replaceAll("-", "");
		System.out.println(dateString);
		dateString = dateString.replaceAll(".", "");
		System.out.println(dateString);
		Long data = Long.valueOf(dateString);
		System.out.println(data);
		return data;
	}

	public void quickSortMessage(List<Long> arr, int left, int right, List<MessageVO> messages) {
		int index = partition(arr, left, right, messages);
		if (left < index - 1) {
			quickSortMessage(arr, left, index - 1, messages);
		}
		if (index < right) {
			quickSortMessage(arr, index, right, messages);
		}

	}

	private int partition(List<Long> arr, int left, int right, List<MessageVO> messages) {
		int i = left, j = right;
		long pivot = arr.get(left + right) / 2;

		while (i <= j) {
			while (arr.get(i) < pivot) {
				i++;
			}
			while (arr.get(j) > pivot) {
				j--;
			}
			if (i <= j) {

				swap(arr, i, j);
				swap(messages, i, j);

				i++;
				j--;
			}
		}
		return i;
	}

	private <T> void swap(List<T> arr, int i, int j) {
		T temp;
		temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

}
