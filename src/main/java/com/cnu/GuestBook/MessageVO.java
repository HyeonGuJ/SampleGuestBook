package com.cnu.GuestBook;

import lombok.Data;

@Data
public class MessageVO {
	
	private int idMessage;
	private String email;
	private String password;
	private String date;
	private String ModifiedDate;
	private String text;


	@Override
	public String toString() {
		return "MessageVO [idMessage=" + idMessage + ", email=" + email + ", password=" + password + ", date=" + date
				+ ", ModifiedDate=" + ModifiedDate + ", text=" + text + "]";
	}

	
	
}
