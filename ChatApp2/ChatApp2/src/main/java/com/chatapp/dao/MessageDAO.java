package com.chatapp.dao;

import com.chatapp.model.Message;
import java.util.List;

public interface MessageDAO {
    void addMessage(Message message);
    List<Message> getMessagesByUser(int userId);
    List<Message> getMessagesByGroup(int groupId);
}
