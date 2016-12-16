package com.cnu.GuestBook.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cnu.GuestBook.domain.MessageVO;

@Repository(value = "MessageMapper")
public interface MessageMapper {
	
	public List<MessageVO> getSelectAll();

	public MessageVO getSelectOne(int idx);

	public void insert(MessageVO msg);

	public void update(MessageVO msg);

	public void delete(int idx);
}