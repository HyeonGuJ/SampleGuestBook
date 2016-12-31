package com.cnu.GuestBook;

public class MessageVO {
	
	private int idMessage;
	private String email;
	private String password;
	private String date;
	private String ModifiedDate;
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



	public String getModifiedDate() {
		return ModifiedDate;
	}



	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	@Override
	public String toString() {
		return "MessageVO [idMessage=" + idMessage + ", email=" + email + ", password=" + password + ", date=" + date
				+ ", ModifiedDate=" + ModifiedDate + ", text=" + text + "]";
	}

	
	
}
