package com.cnu.GuestBook.persistence;

import java.util.List;

import com.cnu.GuestBook.domain.*;

public interface MessageDAO {
	
	public List<Message> selectAllMessage();

	public Message selectMessage(String idMessage);

	public void insertMessage(Message msg);

	public void updateMessage(Message msg);

	public void deleteMessage(String idMessage);
}