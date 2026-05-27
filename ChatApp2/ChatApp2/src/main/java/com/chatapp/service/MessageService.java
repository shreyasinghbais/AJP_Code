package com.chatapp.service;

import com.chatapp.dao.MessageDAO;
import com.chatapp.model.Message;

import java.util.List;

public class MessageService {
    private MessageDAO messageDAO;

    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public void sendMessage(Message message) {
        messageDAO.addMessage(message);
    }

    public List<Message> getMessagesByUser(int userId) {
        return messageDAO.getMessagesByUser(userId);
    }

    public List<Message> getMessagesByGroup(int groupId) {
        return messageDAO.getMessagesByGroup(groupId);
    }
}
