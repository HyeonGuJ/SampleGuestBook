package com.cnu.GuestBook;

import java.util.Date;

public class MessageVO {
	private int idMessage;

	private String email;
	private String password;
	private String date;
	private String text;

	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", email=" + email + ", password=" + password + ", date=" + date + ", text=" + text
				+ "]";
	}	
	
	
}
