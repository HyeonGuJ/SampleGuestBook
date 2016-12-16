package com.cnu.GuestBook.persistence;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cnu.GuestBook.domain.MessageVO;

@Service(value = "MessageDAO")
public class MessageDAO {
	
    @Resource(name = "MessageMapper")
    private MessageMapper messageMapper;

    public List<MessageVO> getSelectAll() {
        return this.messageMapper.getSelectAll();
    }

    public MessageVO getSelectOne(int idx) {
        return this.messageMapper.getSelectOne(idx);
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


