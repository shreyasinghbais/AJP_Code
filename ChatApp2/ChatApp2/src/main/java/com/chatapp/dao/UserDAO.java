package com.chatapp.dao;

import com.chatapp.model.User;
import java.util.List;

public interface UserDAO {
    void addUser(User user);
    User getUser(int id);
    User getUserByName(String name);
    List<User> getAllUsers();
}
