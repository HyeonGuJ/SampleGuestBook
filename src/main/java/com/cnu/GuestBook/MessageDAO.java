package com.cnu.GuestBook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service(value = "MessageDAO")
public class MessageDAO {
	
    @Resource(name = "MessageMapper")
    private MessageMapper messageMapper;

    public List<MessageVO> select() {
        return this.messageMapper.select();
    }

    public MessageVO getSelectOne(int idx) {
        return this.messageMapper.selectOne(idx);
    }

    public void insert(MessageVO MessageVO) {
         this.messageMapper.insert(MessageVO);
    }

    public void update(MessageVO MessageVO) {
         this.messageMapper.update(MessageVO);
    }

    public void delete(int idx) {
         this.messageMapper.delete(idx);
    }

}


