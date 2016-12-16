package com.cnu.GuestBook;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository(value = "MessageMapper")
public interface MessageMapper {
	
    List<MessageVO> select();
    MessageVO selectOne(int idx);
    void insert(MessageVO MessageVO);
    void update(MessageVO MessageVO);
    void delete(int idx);
}